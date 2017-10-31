package com.welkin.springbootseed.service.order.impl;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import com.welkin.springbootseed.service.order.OrderRedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class OrderRedisServiceImpl implements OrderRedisService {

  private static final Logger logger = LogManager.getLogger(OrderRedisServiceImpl.class);

  private static final String ORDER_REDIS_PREFIX = "order_";

  @Autowired private StringRedisTemplate template;

  @Override
  public void save(Order order) {
    ValueOperations<String, String> ops = template.opsForValue();
    String key = ORDER_REDIS_PREFIX + order.getId();
    if (!template.hasKey(key)) {
      ops.set(key, JSON.toJSONString(order));
    }
  }

  @Override
  public void delete(Integer orderId) {
    String key = ORDER_REDIS_PREFIX + orderId;
    template.delete(key);
  }
}
