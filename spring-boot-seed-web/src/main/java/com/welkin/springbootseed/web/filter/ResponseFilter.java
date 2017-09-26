package com.welkin.springbootseed.web.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.welkin.springbootseed.common.Result;
import com.welkin.springbootseed.common.jackson.JacksonUtil;
import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.springframework.util.StringUtils;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Type;

@Provider
@Priority(value = Priorities.USER)
public class ResponseFilter implements ContainerResponseFilter {

  private static final String[][] BASIC_ESCAPE = {
    {"<", "&lt;"}, // < - less-than
    {">", "&gt;"}, // > - greater-than
  };
  private static final CharSequenceTranslator ESCAPE_BASIC =
      new AggregateTranslator(new LookupTranslator(BASIC_ESCAPE));

  @Override
  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {

    // except swagger
    String path = requestContext.getUriInfo().getPath();
    if (path.contains("swagger.json")) return;

    Object result = responseContext.getEntity();
    // redirect 重定向 不需要包装Result
    String location = responseContext.getHeaderString("Location");
    if (!StringUtils.isEmpty(location)) {
      return;
    }
    Type entityType = responseContext.getEntityType();
    if (entityType != null) {
      String typeName = entityType.getTypeName();
      if (typeName.contains("AttachmentApi")) {
        return;
      }
    }

    // 没有经过包装的class
    if (result != null && !(result instanceof Result)) {
      if (result instanceof StreamingOutput) {
        return;
      }
      String resultString = new JacksonUtil(JsonInclude.Include.NON_NULL).toJson(result);
      String escapedStr = escapeHtml(resultString);
      Result entity =
          Result.createSuccess(JacksonUtil.nonEmptyMapper().getMapper().readTree(escapedStr));
      responseContext.setEntity(entity);
    }
  }

  private String escapeHtml(String str) {
    return ESCAPE_BASIC.translate(str);
  }
}
