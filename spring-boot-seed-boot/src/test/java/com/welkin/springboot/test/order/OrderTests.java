package com.welkin.springboot.test.order;

import com.alibaba.fastjson.JSON;
import com.welkin.springboot.test.BaseTests;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import com.welkin.springbootseed.service.order.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderTests extends BaseTests {
  @Autowired private OrderService orderService;

  @Test
  public void test() {
    Assert.assertTrue(1 == 1);
  }

  @Test
  public void getTest() {
    Order order = orderService.get(1000);
    System.out.println(JSON.toJSONString(order));
    Assert.assertTrue(order != null);
  }

  @Test
  public void saveTest() {
      Order order=new Order();
      order.setCityId(112);
      order.setOrderCenterNo(123L);
      orderService.save(order);
  }
}
