package com.welkin.springbootseed.dao.mongo.order.impl;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.dao.mongo.order.IOrderMongoDao;
import com.welkin.springbootseed.model.entity.mongo.order.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * mongoTemplate 方式实现 OrderMongoDaoImpl<br>
 *
 * @author welkin
 */
@Repository
public class OrderMongoDaoImpl implements IOrderMongoDao {

  private static final Logger logger = LogManager.getLogger(OrderMongoDaoImpl.class);

  @Autowired private MongoTemplate mongoTemplate;

  @Override
  public boolean save(Order order) {
    boolean result = false;
    try {
      mongoTemplate.save(order);
      result = true;
    } catch (Exception e) {
      logger.warn(
          "Failed to save order. The order is {}. The exception is ", JSON.toJSONString(order), e);
    }
    return result;
  }

  @Override
  public boolean update(Order order) {
    return save(order);
  }

  @Override
  public boolean delete(String id) {
    boolean result = false;
    try {
      mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Order.class);
      result = true;
    } catch (Exception e) {
      logger.warn("Failed to delete the growthFundInterviewInfo by {}. The exception is ", id, e);
    }
    return result;
  }

  @Override
  public Order getById(String id) {
    Order order = null;
    try {
      order = mongoTemplate.findById(id, Order.class);
    } catch (Exception e) {
      logger.warn("We can't find order by the id[{}]. The exception is ", id, e);
    }
    return order;
  }

  @Override
  public Order getByOrderId(int orderId) {
    Order order = null;
    try {
      Criteria criteria = Criteria.where("orderId").is(orderId);
      Query query = new Query(criteria);
      order = mongoTemplate.findOne(query, Order.class);
    } catch (Exception e) {
      logger.warn("We can't find order by the orderId[{}]. The exception is ", orderId, e);
    }
    return order;
  }

  @Override
  public List<Order> getAll() {
    List<Order> orders = new ArrayList<>();
    try {
      orders.addAll(mongoTemplate.findAll(Order.class));
    } catch (Exception e) {
      logger.warn("We can't find orders. The exception is ", e);
    }
    return orders;
  }
}
