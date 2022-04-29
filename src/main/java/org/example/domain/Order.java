package org.example.domain;

import java.sql.Timestamp;

/**
 * 存储订单表的信息
 */
public class Order {
    private int id;//订单编号
    private int mch_id;//商户id
    private String out_trade_no;//?
    private String transaction_id;//事务id
    private Timestamp start_time;

    private String username;//用户虚拟编号，用户自己填写
    private String list;//奶茶订单列表
    private double amount;
    /*
        订单状态status
        0：正在制作奶茶
        1：订单已成功
        -1：订单失败
     */
    private int status;
    private String remark;

    public Order() {
    }

    public Order(int mch_id, String out_trade_no, String transaction_id, Timestamp start_time, String username, String list, double amount, int status, String remark) {
        this.mch_id = mch_id;
        this.out_trade_no = out_trade_no;
        this.transaction_id = transaction_id;
        this.start_time = start_time;
        this.username = username;
        this.list = list;
        this.amount = amount;
        this.status = status;
        this.remark = remark;
    }

    public Order(int id, int mch_id, String out_trade_no, String transaction_id, Timestamp start_time, String username, String list, double amount, int status, String remark) {
        this.id = id;
        this.mch_id = mch_id;
        this.out_trade_no = out_trade_no;
        this.transaction_id = transaction_id;
        this.start_time = start_time;
        this.username = username;
        this.list = list;
        this.amount = amount;
        this.status = status;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMch_id() {
        return mch_id;
    }

    public void setMch_id(int mch_id) {
        this.mch_id = mch_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", mch_id=" + mch_id +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", start_time=" + start_time +
                ", username='" + username + '\'' +
                ", list='" + list + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
