package com.welkin.springbootseed.service.order.impl;

import com.welkin.springbootseed.dao.elasticsearch.order.OrderElasticsearchRepository;
import com.welkin.springbootseed.model.entity.elasticsearch.order.Order;
import com.welkin.springbootseed.service.order.OrderElasticsearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderElasticsearchServiceImpl implements OrderElasticsearchService {
  private static final Logger logger = LogManager.getLogger(OrderElasticsearchServiceImpl.class);

  @Autowired private OrderElasticsearchRepository repository;

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
