package com.welkin.springbootseed.service.order.impl;

import com.welkin.springbootseed.dao.order.OrderDao;
import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.service.order.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

  @Autowired
  private OrderDao orderDao;

  @Override
  public Order getOrder(Integer orderId) {
    logger.info("orderId: " + orderId);
    return orderDao.selectByPrimaryKey(orderId);
  }
}
