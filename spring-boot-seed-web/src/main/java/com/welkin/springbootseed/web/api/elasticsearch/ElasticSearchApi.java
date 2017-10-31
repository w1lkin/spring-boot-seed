package com.welkin.springbootseed.web.api.elasticsearch;

import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.model.entity.elasticsearch.order.Order;
import com.welkin.springbootseed.service.order.OrderElasticsearchService;
import com.welkin.springbootseed.web.api.elasticsearch.model.CreateOrModifyOrderESRequest;
import com.welkin.springbootseed.web.api.elasticsearch.model.CreateOrModifyOrderESResponse;
import com.welkin.springbootseed.web.api.elasticsearch.model.OrderESResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * elasticsearch CRUD
 *
 * @author welkin
 */
@Path("elasticsearch")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "elasticsearch CRUD", description = "elasticsearch CRUD")
public class ElasticSearchApi {
  private static final Logger logger = LogManager.getLogger(ElasticSearchApi.class);

  @Autowired private OrderElasticsearchService orderService;

  @GET
  @Path("/orders/{orderId}")
  @ApiOperation("获取订单")
  public OrderESResponse get(@PathParam("orderId") Integer orderId) {
    Order order = orderService.get(orderId);
    BizException.isNull(order, "订单不存在");
    //
    OrderESResponse response = new OrderESResponse();
    BeanUtil.copyProperties(order, response);
    return response;
  }

  @POST
  @Path("/orders")
  @ApiOperation("创建订单")
  public CreateOrModifyOrderESResponse create(@Valid CreateOrModifyOrderESRequest request) {
    Order order = new Order();
    BeanUtil.copyProperties(request, order);
    orderService.save(order);
    //
    CreateOrModifyOrderESResponse response = new CreateOrModifyOrderESResponse();
    response.setOrderId(order.getOrderId());
    return response;
  }

  @PUT
  @Path("/orders")
  @ApiOperation("更新订单")
  public CreateOrModifyOrderESResponse update(@Valid CreateOrModifyOrderESRequest request) {
    Integer orderId = request.getOrderId();
    BizException.isNull(orderId);
    //
    Order order = orderService.get(orderId);
    BizException.isNull(order, "订单不存在");
    BeanUtil.copyProperties(request, order);
    orderService.update(order);
    //
    CreateOrModifyOrderESResponse response = new CreateOrModifyOrderESResponse();
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
