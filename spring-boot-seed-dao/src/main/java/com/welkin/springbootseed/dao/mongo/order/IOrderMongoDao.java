package com.welkin.springbootseed.dao.mongo.order;

import com.welkin.springbootseed.model.entity.mongo.order.Order;

import java.util.List;

/**
 * IOrderMongoDao<br>
 *
 * @author welkin
 */
public interface IOrderMongoDao {

  /**
   * 保存数据
   *
   * @param order
   * @return
   */
  boolean save(Order order);

  /**
   * 更新数据
   *
   * @param order
   * @return
   */
  boolean update(Order order);

  /**
   * 根据id删除数据
   *
   * @param id
   * @return
   */
  boolean delete(String id);

  /**
   * 根据id获取数据
   *
   * @param id
   * @return
   */
  Order getById(String id);

  /**
   * 根据orderId获取数据
   *
   * @param orderId
   * @return
   */
  Order getByOrderId(int orderId);

  /**
   * 获取所有数据
   *
   * @return
   */
  List<Order> getAll();
}
