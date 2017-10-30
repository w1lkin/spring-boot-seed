package com.welkin.springbootseed.service.order.impl;

import com.welkin.springbootseed.dao.index.order.OrderRepository;
import com.welkin.springbootseed.model.entity.index.order.Order;
import com.welkin.springbootseed.service.order.OrderServiceES;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceESImpl implements OrderServiceES {
  private static final Logger logger = LogManager.getLogger(OrderServiceESImpl.class);

  @Autowired private OrderRepository repository;

  @Override
  public Order get(Integer orderId) {
    return repository.getByOrderId(orderId);
  }

  @Override
  @Transactional
  public void save(Order order) {
    repository.save(order);
  }

  @Override
  @Transactional
  public void update(Order order) {
    repository.save(order);
  }

  @Override
  @Transactional
  public void remove(Integer orderId) {
    repository.deleteByOrderId(orderId);
  }
}
