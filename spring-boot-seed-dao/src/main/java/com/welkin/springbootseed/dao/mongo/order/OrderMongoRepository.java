package com.welkin.springbootseed.dao.mongo.order;

import com.welkin.springbootseed.model.entity.mongo.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderMongoRepository extends MongoRepository<Order, String> {
  /**
   * 根据 orderId 获取
   *
   * @param orderId
   * @return
   */
  Order getByOrderId(int orderId);

  /**
   * 根据 orderId 删除
   *
   * @param orderId
   */
  void deleteByOrderId(int orderId);
}
