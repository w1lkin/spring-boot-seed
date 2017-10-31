package com.welkin.springbootseed.web.api.mongo;

import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.model.entity.mongo.order.Order;
import com.welkin.springbootseed.service.order.OrderMongoService;
import com.welkin.springbootseed.web.api.mongo.model.CreateOrModifyOrderMongoRequest;
import com.welkin.springbootseed.web.api.mongo.model.CreateOrModifyOrderMongoResponse;
import com.welkin.springbootseed.web.api.mongo.model.OrderMongoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * mongo CRUD
 *
 * @author welkin
 */
@Path("mongo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "mongo CRUD", description = "mongo CRUD")
public class MongoApi {
  private static final Logger logger = LogManager.getLogger(MongoApi.class);

  @Autowired private OrderMongoService orderService;

  @GET
  @Path("/orders/{orderId}")
  @ApiOperation("获取订单")
  public OrderMongoResponse get(@PathParam("orderId") Integer orderId) {
    Order order = orderService.get(orderId);
    BizException.isNull(order, "订单不存在");
    //
    OrderMongoResponse response = new OrderMongoResponse();
    BeanUtil.copyProperties(order, response);
    return response;
  }

  @POST
  @Path("/orders")
  @ApiOperation("创建订单")
  public CreateOrModifyOrderMongoResponse create(@Valid CreateOrModifyOrderMongoRequest request) {
    Order order = new Order();
    BeanUtil.copyProperties(request, order);
    orderService.save(order);
    //
    CreateOrModifyOrderMongoResponse response = new CreateOrModifyOrderMongoResponse();
    response.setOrderId(order.getOrderId());
    return response;
  }

  @PUT
  @Path("/orders")
  @ApiOperation("更新订单")
  public CreateOrModifyOrderMongoResponse update(@Valid CreateOrModifyOrderMongoRequest request) {
    Integer orderId = request.getOrderId();
    BizException.isNull(orderId);
    //
    Order order = orderService.get(orderId);
    BizException.isNull(order, "订单不存在");
    BeanUtil.copyProperties(request, order);
    orderService.update(order);
    //
    CreateOrModifyOrderMongoResponse response = new CreateOrModifyOrderMongoResponse();
    response.setOrderId(order.getOrderId());
    return response;
  }

  @DELETE
  @Path("/orders/{orderId}")
  @ApiOperation("删除订单")
  public Boolean delete(@PathParam("orderId") Integer orderId) {
    orderService.remove(orderId);
    return true;
  }
}
