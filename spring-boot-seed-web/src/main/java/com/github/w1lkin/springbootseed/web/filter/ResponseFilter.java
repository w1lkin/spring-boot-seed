package com.github.w1lkin.springbootseed.web.filter;

import com.github.w1lkin.springbootseed.common.Result;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Objects;

@Provider
@Priority(value = Priorities.USER)
public class ResponseFilter implements ContainerResponseFilter {

  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {
    Object result = responseContext.getEntity();

    if (Objects.nonNull(result)) {
      if (result instanceof Result) {
        return;
      }
      if (result instanceof StreamingOutput) {
        return;
      }
      Result<Object> entity = Result.createSuccess(result);
      responseContext.setEntity(entity);
    }
  }
}
