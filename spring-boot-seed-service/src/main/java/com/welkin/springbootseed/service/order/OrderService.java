package com.welkin.springbootseed.service.order;

import com.welkin.springbootseed.model.Page;
import com.welkin.springbootseed.model.dto.order.SearchOrderCondition;
import com.welkin.springbootseed.model.entity.mysql.order.Order;

import java.util.List;

/**
 * 订单服务 接口
 *
 * @author welkin
 */
public interface OrderService {
  /**
   * 获取订单
   *
   * @param orderId
   * @return
   */
  Order get(Integer orderId);

  /**
   * 插入订单
   *
   * @param order
   * @return
   */
  void save(Order order);

  /**
   * 更新订单
   *
   * @param order
   * @return
   */
  void update(Order order);

  /**
   * 删除订单
   *
   * @param orderId
   */
  void remove(Integer orderId);

  /**
   * 搜索订单
   *
   * @param condition
   * @return
   */
  Page<Order> findPage(SearchOrderCondition condition);

  /**
   * 获取订单列表
   *
   * @return
   */
  List<Order> getList();
}
