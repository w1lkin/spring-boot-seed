package com.welkin.springbootseed.web.api.stream;

import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.service.order.OrderService;
import com.welkin.springbootseed.web.api.stream.model.StreamResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * stream API 使用
 * @author welkin
 */
@Path("stream")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "stream API 使用", description = "stream API 使用")
public class StreamApi {

  private static final Logger logger = LogManager.getLogger(StreamApi.class);

  @Autowired private OrderService orderService;

  @GET
  @Path("/uses")
  @ApiOperation("uses")
  public StreamResponse uses() {
    List<Order> orders = orderService.getList();
    // 流转换为其它数据结构
    List<Integer> orderIdsList = orders.stream().map(Order::getId).collect(Collectors.toList());
    Map<Integer, Order> orderMap =
        orders.stream().collect(Collectors.toMap(Order::getId, Function.identity()));
    Integer[] orderIdsArray = orders.stream().map(Order::getId).toArray(Integer[]::new);
    String orderIdsString = orders.stream().map(p -> p.getId().toString()).collect(Collectors.joining(",")).toString();
    String orderIdsString2= StringUtils.join(orderIdsList,",");

    // 流的操作
    //    Intermediate：
    //    map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、
    // sequential、 unordered
    //    Terminal：
    //    forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、
    // noneMatch、 findFirst、 findAny、 iterator
    //    Short-circuiting：
    //    anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
    Long amount=orders.stream().filter(p->p.getProductId().equals(1010)).mapToLong(Order::getCustomerId).sum();
    //reduce
    Long amount2=orders.stream().filter(p->p.getProductId().equals(1010)).map(Order::getCustomerId).reduce(0,(a,b)->a+b).longValue();
    Long amount3=orders.stream().filter(p->p.getProductId().equals(1010)).map(Order::getCustomerId).reduce(0,Integer::sum).longValue();
    Long amount4=orders.stream().filter(p->p.getProductId().equals(1010)).map(Order::getCustomerId).reduce(Integer::sum).get().longValue();

    //
    StreamResponse response = new StreamResponse();
    response.setOrderIdsList(orderIdsList);
    response.setOrderMap(orderMap);
    response.setOrderIdsArray(orderIdsArray);
    response.setOrderIdsString(orderIdsString);
    response.setAmount(amount);
    response.setAmount2(amount2);
    response.setAmount3(amount3);
    response.setAmount4(amount4);
    response.setOrderIdsString2(orderIdsString2);
    return response;
  }
}
