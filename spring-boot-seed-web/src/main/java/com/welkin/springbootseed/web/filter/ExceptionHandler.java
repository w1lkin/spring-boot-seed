package com.welkin.springbootseed.web.filter;

import com.welkin.springbootseed.common.ApiResponseCode;
import com.welkin.springbootseed.common.Result;
import com.welkin.springbootseed.common.exception.BizException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

  private static final Logger logger = LogManager.getLogger(ExceptionHandler.class);

  @Override
  public Response toResponse(Exception e) {
    Result<?> result;
    if (e instanceof BizException) {
      BizException appException = (BizException) e;
      result = Result.createUnknowFail(appException.getCode(), appException.getMsg());
      logger.warn("", e);
      return Response.status(Response.Status.OK)
          .entity(result)
          .type(MediaType.APPLICATION_JSON_TYPE + ";charset=UTF-8")
          .encoding(StandardCharsets.UTF_8.name())
          .build();
    } else if (e instanceof ConstraintViolationException) {
      String errorMsg = getValidationMessage((ConstraintViolationException) e);
      result = Result.createUnknowFail(ApiResponseCode.PARA_ERR.get(), errorMsg);
      logger.warn(errorMsg, e);
      return Response.status(Response.Status.OK)
          .entity(result)
          .type(MediaType.APPLICATION_JSON_TYPE + ";charset=UTF-8")
          .encoding(StandardCharsets.UTF_8.name())
          .build();
    }
    // else if(e instanceof UnauthorizedException) {
    //
    //			result = Result.createUnknowFail(ApiResponseCode.ACCESS_DENIED.get(), "没有权限");
    //			logger.warn("", e);
    //			return Response.status(Response.Status.OK).entity(result)
    //					.type(MediaType.APPLICATION_JSON_TYPE +
    // ";charset=UTF-8").encoding(StandardCharsets.UTF_8.name()).build();
    //		} else if(e instanceof AuthenticationException) {
    //
    //			result = Result.createUnknowFail(ApiResponseCode.NOT_LOG.get(), "未登录");
    //			logger.warn("", e);
    //			return Response.status(Response.Status.OK).entity(result)
    //					.type(MediaType.APPLICATION_JSON_TYPE +
    // ";charset=UTF-8").encoding(StandardCharsets.UTF_8.name()).build();
    //		} else if(e instanceof RpcException) {
    //			logger.error("", e);
    //			result = Result.createUnknowFail(ApiResponseCode.EXTERNAL_SERVICE_EXP.get(),
    // e.getMessage());
    //			return Response.status(Response.Status.OK).entity(result)
    //					.type(MediaType.APPLICATION_JSON_TYPE +
    // ";charset=UTF-8").encoding(StandardCharsets.UTF_8.name()).build();
    //		}
    else {
      result = Result.createUnknowFail(ApiResponseCode.UN_KNONW_ERROR.get(), "未知异常");
      logger.error("", e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(result)
          .type(MediaType.APPLICATION_JSON_TYPE + ";charset=UTF-8")
          .encoding(StandardCharsets.UTF_8.name())
          .build();
    }
  }

  // 校验错误
  private String getValidationMessage(ConstraintViolationException exception) {
    StringBuilder sb = new StringBuilder();
    for (Iterator<ConstraintViolation<?>> iter = exception.getConstraintViolations().iterator();
        iter.hasNext(); ) {
      ConstraintViolation<?> next = iter.next();
      sb.append(next.getMessage());
      sb.append(",");
    }
    if (sb.length() != 0) {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }
}
