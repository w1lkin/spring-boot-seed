package com.welkin.springbootseed.service.order;

import com.welkin.springbootseed.model.Page;
import com.welkin.springbootseed.model.order.Order;
import com.welkin.springbootseed.model.order.dto.SearchOrderCondition;

/**
 * @author welkin
 * 2017年9月28日16:04:53
 */
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
    Page<Order> findPage(SearchOrderCondition condition);
}
