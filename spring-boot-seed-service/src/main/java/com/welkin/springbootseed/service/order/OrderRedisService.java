package com.welkin.springbootseed.service.order;

import com.welkin.springbootseed.model.entity.mysql.order.Order;

/** @author welkin 2017年9月28日16:04:53 */
public interface OrderRedisService {

  /**
   * 插入订单
   *
   * @param order
   * @return
   */
  void save(Order order);

  /**
   * 删除订单
   *
   * @param orderId
   */
  void delete(Integer orderId);
}
