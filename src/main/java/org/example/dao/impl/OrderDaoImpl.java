package org.example.dao.impl;

import org.example.dao.OrderDao;
import org.example.domain.Order;
import org.example.domain.Tea;
import org.example.utils.JDBCUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 对order表进行操作
 */
public class OrderDaoImpl implements OrderDao {
    Connection conn;
    PreparedStatement psta;
    Statement sta;
    ResultSet rs;

    @Override
    public Order getOrderById(int id) {
        return null;
    }

    @Override
    public Order getOrderByMchId(int mch_id) {
        return null;
    }

    @Override
    public Order getOrderByOutTradeId(String out_trade_id) {
        return null;
    }

    @Override
    public Order getOrderByTransactionId(String transaction_id) {
        return null;
    }

    @Override
    public Order getOrderByUsername(String username) {
        return null;
    }


    @Override
    public List<Order> getOrdersByStatus(int status) {
        List<Order> res = new ArrayList<>();
        try {
            String sql ="SELECT * FROM order_ WHERE status=?";

            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setInt(1,status);

            rs = psta.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int mch_id = rs.getInt("mch_id");
                String out_trade_no = rs.getString("out_trade_no");
                String transaction_no = rs.getString("transaction_id");
                Timestamp start_time = rs.getTimestamp("start_time");
                String username = rs.getString("username");
                String list = rs.getString("list");
                double amount = rs.getDouble("amount");
                String remark = rs.getString("remark");


                Order order = new Order(id,mch_id,out_trade_no,transaction_no,start_time,username,
                        list,amount,status,remark);
                System.out.println(order);
                res.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, sta,conn);
        }

        return res;
    }

    @Override
    public List<Order> getAll() {
        List<Order> res = new ArrayList<>();
        try {
            String sql ="SELECT * FROM order_";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                int mch_id = rs.getInt("mch_id");
                String out_trade_no = rs.getString("out_trade_no");
                String transaction_no = rs.getString("transaction_id");
                Timestamp start_time = rs.getTimestamp("start_time");
                String username = rs.getString("username");
                String list = rs.getString("list");
                double amount = rs.getDouble("amount");
                int status = rs.getInt("status");
                String remark = rs.getString("remark");


                Order order = new Order(id,mch_id,out_trade_no,transaction_no,start_time,username,
                        list,amount,status,remark);
                res.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, sta,conn);
        }

        return res;
    }

    @Override
    public boolean updateOrderStatus(int id,int status) {
        String sql = "update order_ set status=? where id=?";
        int res = 0;
        try {
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);

            psta.setInt(1,status);
            psta.setInt(2,id);

            res = psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res > 0;
    }

    @Override
    public boolean updateOrderRemark(int id, String remark) {
        String sql = "update order_ set remark=? where id=?";
        int res = 0;
        try {
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);

            psta.setString(1,remark);
            psta.setInt(2,id);

            res = psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res > 0;
    }

    @Override
    public boolean add(Order order) {
        int i = 0;
        try {
            String sql = "Insert Into order_(mch_id,out_trade_no,transaction_id,start_time,username,list,amount,status,remark) " +
                    "Values (?,?,?,?,?,?,?,?,?)";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);

            psta.setInt(1,order.getMch_id());
            psta.setString(2,order.getOut_trade_no());
            psta.setString(3,order.getTransaction_id());
            psta.setTimestamp(4,order.getStart_time());
            psta.setString(5,order.getUsername());
            psta.setString(6,order.getList());
            psta.setDouble(7,order.getAmount());
            psta.setInt(8,order.getStatus());
            psta.setString(9,order.getRemark());

            i = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,psta,conn);
        }
        return i > 0;
    }

    public static void main(String[] args) throws ParseException {
        OrderDaoImpl test = new OrderDaoImpl();
        String orderTime = "2022-04-09 10:28:12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Timestamp timestamp = new Timestamp(sdf.parse(orderTime).getTime());
        System.out.println(timestamp.toString());

        Order order = new Order(123456,"12311","442232",timestamp,"张三丰","珍珠奶茶 2 柠檬茶 1",53.5,0,"多糖加冰打包带走");
        test.add(order);
    }
}