package com.welkin.springbootseed.dao.mysql.order;

import com.welkin.springbootseed.model.dto.order.SearchOrderCondition;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义订单 Dao
 *
 * @author welkin
 */
public interface CustomOrderDao extends OrderDao {
  /**
   * 删除
   *
   * @param orderId
   * @return
   */
  int removeByOrderId(@Param("orderId") Integer orderId);

  /**
   * 根据 搜索条件 查找
   *
   * @param condition
   * @return
   */
  List<Order> selectByCondition(SearchOrderCondition condition);
}
