package com.welkin.springbootseed.web.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.IOException;

@FilterTest
@Priority(Priorities.USER)
@Provider
// 针对实体的操作
public class InterceptorTestInterceptor implements ReaderInterceptor, WriterInterceptor {
  private static final Logger logger = LogManager.getLogger(InterceptorTestInterceptor.class);

  @Override
  public Object aroundReadFrom(ReaderInterceptorContext context)
      throws IOException, WebApplicationException {
    //
    logger.info("ReaderInterceptorContext: 2");
    return null;
  }

  @Override
  public void aroundWriteTo(WriterInterceptorContext context)
      throws IOException, WebApplicationException {
    // 5
    logger.info("WriterInterceptorContext: 5");
  }
}
