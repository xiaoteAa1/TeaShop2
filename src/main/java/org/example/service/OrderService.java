package org.example.service;

import org.example.domain.Order;

import java.util.List;

public interface OrderService {
    //SELECT
    List<Order> getAll();
    List<Order> getOrdersByStatus(int status);

    //UPDATE
    //完结订单
    boolean updateOrderStatusTo1(int id);
    //更新订单备注
    boolean updateOrderRemark(int id,String remark);

    //INSERT
    boolean add(Order order);
}
