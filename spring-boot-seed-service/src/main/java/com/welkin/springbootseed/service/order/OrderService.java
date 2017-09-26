package com.welkin.springbootseed.service.order;

import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.model.order.SearchOrderCondition;

import java.util.List;

public interface OrderService {
    /**
     * 获取订单
     * @param orderId
     * @return
     */
    Order get(Integer orderId);

    /**
     * 插入订单
     * @param order
     * @return
     */
    void save(Order order);

    /**
     * 更新订单
     * @param order
     * @return
     */
    void update(Order order);

    /**
     * 删除订单
     * @param orderId
     */
    void remove(Integer orderId);

    /**
     * 搜索订单
     * @param condition
     * @return
     */
    List<Order> findPage(SearchOrderCondition condition);
}
