package com.welkin.springbootseed.service.order;

import com.welkin.springbootseed.model.order.Order;

public interface OrderService {
    Order getOrder(Integer orderId);
}
