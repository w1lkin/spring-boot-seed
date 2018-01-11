package com.welkin.springbootseed.web.filter;

import com.welkin.springbootseed.common.util.SpringUtil;
import com.welkin.springbootseed.service.order.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@FilterTest
@Priority(Priorities.USER)
@Provider
// 操纵请求和响应参数
public class FilterTestFilter implements ContainerRequestFilter, ContainerResponseFilter {
  private static final Logger logger = LogManager.getLogger(FilterTestFilter.class);

  private OrderService orderService;

  public FilterTestFilter(OrderService orderService) {
    this.orderService = SpringUtil.getBean(OrderService.class);
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    //
    logger.error("ContainerRequestContext: 1");
  }

  @Override
  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {
    //
    logger.error("ContainerRequestContext: 4");
  }
}
