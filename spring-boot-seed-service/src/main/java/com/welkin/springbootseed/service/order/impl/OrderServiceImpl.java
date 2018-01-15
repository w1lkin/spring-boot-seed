package com.welkin.springbootseed.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.welkin.springbootseed.dao.mysql.order.CustomOrderDao;
import com.welkin.springbootseed.model.Page;
import com.welkin.springbootseed.model.dto.order.SearchOrderCondition;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import com.welkin.springbootseed.service.annotation.AnnotationTest;
import com.welkin.springbootseed.service.order.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单服务接口实现
 *
 * @author welkin
 */
@Service
public class OrderServiceImpl implements OrderService {
  private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

  @Autowired private CustomOrderDao orderDao;

  @Override
  @AnnotationTest(name = "welkin")
  public Order get(Integer orderId) {
    logger.info("orderId: " + orderId);
    return orderDao.selectByPrimaryKey(orderId);
  }

  @Override
  @Transactional
  public void save(Order order) {
    orderDao.insertSelective(order);
  }

  @Override
  @Transactional
  public void update(Order order) {
    orderDao.updateByPrimaryKeySelective(order);
  }

  @Override
  @Transactional
  public void remove(Integer orderId) {
    orderDao.removeByOrderId(orderId);
  }

  @Override
  public Page<Order> findPage(SearchOrderCondition condition) {
    PageHelper.startPage(condition.getPageNo(), condition.getPageSize());
    List<Order> orders = orderDao.selectByCondition(condition);
    Page<Order> page = new Page<>(orders);
    return page;
  }

  @Override
  public List<Order> getList() {
    return orderDao.selectByCondition(null);
  }
}
