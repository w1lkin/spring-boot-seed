package com.welkin.springbootseed.web.api.mybatis;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.service.order.OrderService;
import com.welkin.springbootseed.web.api.mybatis.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/** @author welkin Mybatis */
@Path("")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "Mybatis", description = "Mybatis")
public class MybatisApi {

  private static final Logger logger = LogManager.getLogger(MybatisApi.class);

  @Autowired
  private OrderService orderService;

  @GET
  @Path("/orders/{orderId}")
  @ApiOperation("获取订单")
  public OrderResponse get(@PathParam("orderId") Integer orderId) {
    logger.info("request: " + orderId);

    Order order = orderService.getOrder(orderId);
    //
    OrderResponse response = new OrderResponse();
    BeanUtil.copyProperties(order,response);
    //
    logger.info("response: " + JSON.toJSONString(response));
    return response;
  }

  @GET
  @Path("/orders")
  @ApiOperation("搜索订单")
  public SearchOrderResponse search(@BeanParam SearchOrderRequest request) {
    SearchOrderResponse response=new SearchOrderResponse();
    return response;
  }

  @POST
  @Path("/orders")
  @ApiOperation("创建订单")
  public CreateOrderResponse create(CreateOrderRequest request){
    CreateOrderResponse response=new CreateOrderResponse();
    return response;
  }

  @PUT
  @Path("/orders")
  @ApiOperation("更新订单")
  public CreateOrderResponse update(CreateOrderRequest request){
    CreateOrderResponse response=new CreateOrderResponse();
    return response;
  }

  @DELETE
  @Path("/orders/{orderId}")
  @ApiOperation("删除订单")
  public CreateOrderResponse delete(@PathParam("orderId") Integer orderId){
    CreateOrderResponse response=new CreateOrderResponse();
    return response;
  }

}
