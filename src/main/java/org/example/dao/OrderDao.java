package org.example.dao;

import org.example.domain.Order;

import java.sql.Timestamp;
import java.util.List;

/**
 * 操作订单表Order
 */
public interface OrderDao {
    //SELECT
    Order getOrderById(int id);
    Order getOrderByMchId(int mch_id);
    Order getOrderByOutTradeId(String out_trade_id);
    Order getOrderByTransactionId(String transaction_id);
    Order getOrderByUsername(String username);

    List<Order> getOrdersByStatus(int status);


    //SELECT ALL
    List<Order> getAll();


    //UPDATE
    boolean updateOrderStatus(int id,int status);
    boolean updateOrderRemark(int id,String remark);

    //ADD
    boolean add(Order order);


    //DELETE


}