package com.welkin.springbootseed.dao.order;

import org.apache.ibatis.annotations.Param;

public interface CustomOrderDao extends OrderDao{
    /**
     * 删除
     * @param orderId
     * @return
     */
    int removeByOrderId(@Param("orderId") Integer orderId);
}