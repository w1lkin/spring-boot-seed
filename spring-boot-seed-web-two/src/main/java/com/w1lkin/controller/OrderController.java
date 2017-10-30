package com.w1lkin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import com.welkin.springbootseed.service.order.OrderService;
import com.welkin.springbootseed.web.api.mysql.model.OrderResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author ErnestCheng
 * @data 2017/10/30
 * @since 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{orderId}")
    @ApiOperation("获取订单")
    public OrderResponse get(@PathVariable("orderId") Integer orderId) {
        Preconditions.checkArgument(orderId>0);
        logger.info("request: " + orderId);
        Order order = orderService.get(orderId);
        OrderResponse response = new OrderResponse();
        BeanUtil.copyProperties(order, response);
        logger.info("response: " + JSON.toJSONString(response));
        return response;
    }

}
