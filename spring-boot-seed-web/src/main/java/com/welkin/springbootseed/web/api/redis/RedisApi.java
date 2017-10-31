package com.welkin.springbootseed.web.api.redis;

import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import com.welkin.springbootseed.service.order.OrderRedisService;
import com.welkin.springbootseed.web.api.redis.model.CreateOrModifyOrderRedisRequest;
import com.welkin.springbootseed.web.api.redis.model.CreateOrModifyOrderRedisResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * mybatis CRUD
 *
 * @author welkin
 */
@Path("redis")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "redis CRUD", description = "redis CRUD")
public class RedisApi {

  private static final Logger logger = LogManager.getLogger(RedisApi.class);

  @Autowired private OrderRedisService orderService;

  @POST
  @Path("/orders")
  @ApiOperation("创建订单")
  public CreateOrModifyOrderRedisResponse create(@Valid CreateOrModifyOrderRedisRequest request) {
    Order order = new Order();
    BeanUtil.copyProperties(request, order);
    orderService.save(order);
    //
    CreateOrModifyOrderRedisResponse response = new CreateOrModifyOrderRedisResponse();
    response.setId(order.getId());
    return response;
  }

  @DELETE
  @Path("/orders/{orderId}")
  @ApiOperation("删除订单")
  public Boolean delete(@PathParam("orderId") Integer orderId) {
    orderService.delete(orderId);
    return true;
  }
}
