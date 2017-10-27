package com.welkin.springbootseed.service.order.impl;

import com.welkin.springbootseed.dao.mongo.order.OrderRepository;
import com.welkin.springbootseed.model.entity.mongo.order.Order;
import com.welkin.springbootseed.service.order.OrderServiceMongo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceMongoImpl implements OrderServiceMongo {
  private static final Logger logger = LogManager.getLogger(OrderServiceMongoImpl.class);

  @Autowired private OrderRepository repository;

  //  @Autowired private IOrderDao repository;

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

  @Override
  public List<Order> getList() {
    return repository.findAll();
    //    return null;
  }
}
