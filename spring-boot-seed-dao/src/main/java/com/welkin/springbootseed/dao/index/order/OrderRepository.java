package com.welkin.springbootseed.dao.index.order;

import com.welkin.springbootseed.model.entity.index.order.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderRepository extends ElasticsearchRepository<Order,String> {
    /**
     * 根据 orderId 获取
     * @param orderId
     * @return
     */
    Order getByOrderId(int orderId);

    /**
     * 根据 orderId 删除
     * @param orderId
     */
    //TODO 删除有问题
    void deleteByOrderId(int orderId);
}
