package com.welkin.springbootseed.dao.elasticsearch.order;

import com.welkin.springbootseed.model.entity.elasticsearch.order.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderElasticsearchRepository extends ElasticsearchRepository<Order, String> {
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
