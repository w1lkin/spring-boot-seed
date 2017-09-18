package com.welkin.springbootseed.dao.order;

import com.welkin.springbootseed.model.order.Order;

public interface OrderDao {
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}