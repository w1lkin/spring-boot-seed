package com.welkin.springbootseed.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.welkin.springbootseed.dao.order.CustomOrderDao;
import com.welkin.springbootseed.model.Page;
import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.model.order.dto.SearchOrderCondition;
import com.welkin.springbootseed.service.order.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
  private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

  @Autowired private CustomOrderDao orderDao;

  @Override
  public Order get(Integer orderId) {
    logger.info("orderId: " + orderId);
    return orderDao.selectByPrimaryKey(orderId);
  }

  @Override
  public void save(Order order) {
    orderDao.insertSelective(order);
  }

  @Override
  public void update(Order order) {
    orderDao.updateByPrimaryKeySelective(order);
  }

  @Override
  public void remove(Integer orderId) {
    orderDao.removeByOrderId(orderId);
  }

  @Override
  public Page<Order> findPage(SearchOrderCondition condition) {
    PageHelper.startPage(condition.getPageNo(),condition.getPageSize());
    List<Order> orders=orderDao.selectByCondition(condition);
    Page<Order> page=new Page<>(orders);
    return page;
  }
}
