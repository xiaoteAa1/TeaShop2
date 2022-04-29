package org.example.service.impl;

import org.example.dao.OrderDao;
import org.example.dao.impl.OrderDaoImpl;
import org.example.domain.Order;
import org.example.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao od = new OrderDaoImpl();
    @Override
    public List<Order> getAll() {
        return od.getAll();
    }

    @Override
    public List<Order> getOrdersByStatus(int status) {
        return od.getOrdersByStatus(status);
    }

    @Override
    public boolean updateOrderStatusTo1(int id) {
        return od.updateOrderStatus(id,1);
    }

    @Override
    public boolean updateOrderRemark(int id, String remark) {
        return od.updateOrderRemark(id,remark);
    }

    @Override
    public boolean add(Order order) {
        return od.add(order);
    }
}
