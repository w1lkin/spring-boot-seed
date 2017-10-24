package com.welkin.springbootseed.web.api.mybatis;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.model.Page;
import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.model.order.dto.SearchOrderCondition;
import com.welkin.springbootseed.service.order.OrderService;
import com.welkin.springbootseed.web.api.mybatis.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * mysql CRUD
 * @author welkin
 **/
@Path("")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "mysql CRUD", description = "mysql CRUD")
public class MybatisApi {
  // TODO 参数校验未生效

  private static final Logger logger = LogManager.getLogger(MybatisApi.class);

  @Autowired private OrderService orderService;

  @GET
  @Path("/orders/{orderId}")
  @ApiOperation("获取订单")
  public OrderResponse get(@PathParam("orderId") Integer orderId) {
    logger.info("request: " + orderId);

    Order order = orderService.get(orderId);
    //
    OrderResponse response = new OrderResponse();
    BeanUtil.copyProperties(order, response);
    //
    logger.info("response: " + JSON.toJSONString(response));
    return response;
  }

  @GET
  @Path("/orders")
  @ApiOperation("搜索订单")
  public SearchOrderResponse search(@BeanParam SearchOrderRequest request) {
    //
    SearchOrderCondition condition=new SearchOrderCondition();
    BeanUtil.copyProperties(request,condition);
    if (request.getEntryBeginTime()!=null){
      condition.setEntryBeginTime(request.getEntryBeginTime().getDate());
    }
    if (request.getEntryEndTime()!=null){
      condition.setEntryEndTime(request.getEntryEndTime().getNextDay());
    }
    //
    Page<Order> page=orderService.findPage(condition);
    //
    List<OrderVo> orderVos=BeanUtil.copyList(page.getResults(),OrderVo.class);
    SearchOrderResponse response = new SearchOrderResponse(page.getTotalCount(),orderVos);
    return response;
  }

  @POST
  @Path("/orders")
  @ApiOperation("创建订单")
  public CreateOrModifyOrderResponse create(@Valid CreateOrModifyOrderRequest request) {
    Order order = new Order();
    BeanUtil.copyProperties(request, order);
    orderService.save(order);
    //
    CreateOrModifyOrderResponse response = new CreateOrModifyOrderResponse();
    response.setId(order.getId());
    return response;
  }

  @PUT
  @Path("/orders")
  @ApiOperation("更新订单")
  public CreateOrModifyOrderResponse update(@Valid CreateOrModifyOrderRequest request) {
    Integer id = request.getId();
    BizException.isNull(id);
    //
    Order order = new Order();
    BeanUtil.copyProperties(request, order);
    orderService.update(order);
    //
    CreateOrModifyOrderResponse response = new CreateOrModifyOrderResponse();
    response.setId(order.getId());
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
