/*
 * Created by JFormDesigner on Thu Apr 28 09:37:41 CST 2022
 */

package org.example.controller.shop_owner.order_manage;

import org.example.controller.shop_owner.OwnerEnter;
import org.example.controller.shop_owner.tea_manage.TeaUpdateDel;
import org.example.domain.Order;
import org.example.domain.Tea;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceImpl;
import org.example.utils.SwingUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class OrderController extends JFrame {
    public OrderController() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        comboBox1 = new JComboBox();
        button2 = new JButton();

        //======== this ========
        setTitle("owner-OrderManagement");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        contentPane.add(button1);
        button1.setBounds(5, 5, 80, 32);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 40, 785, 355);
        contentPane.add(comboBox1);
        comboBox1.setBounds(105, 5, 120, 32);

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        contentPane.add(button2);
        button2.setBounds(230, 5, 85, 32);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(825, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        comboBox1.addItem("");
        comboBox1.addItem("所有订单");
        comboBox1.addItem("当前订单");
        comboBox1.addItem("已完成订单");
        comboBox1.addItem("异常订单");

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1)return;//让该事件监听只执行1次

                String item = comboBox1.getSelectedItem().toString();
                switch (item){
                    case "所有订单" :
                        selectAllOrder();
                        break;
                    case "当前订单" :
                        selectOrderByStatus(0);
                        break;
                    case "已完成订单" :
                        selectOrderByStatus(1);
                        break;
                    case "异常订单" :
                        selectOrderByStatus(-1);
                        break;
                    default:
                        break;
                }
            }
        });

        //1、返回上一级
        button1.addActionListener((e)->{
            this.setVisible(false);

            OwnerEnter oe = new OwnerEnter();
            oe.setVisible(true);
            oe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        //2、刷新面板
        button2.addActionListener((e) -> {
            selectAllOrder();
            comboBox1.setSelectedIndex(0);
        });

        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if(e.getValueIsAdjusting() || selectedRow == -1)return;

                //通过名称获得奶茶
                String teaName = table1.getValueAt(selectedRow, 1).toString();

                //获取到选择的列
                OrderUpdate td = new OrderUpdate(getOrder(selectedRow));
                td.setVisible(true);

                table1.clearSelection();
            }
        });

    }

    void selectAllOrder(){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForOwner_Order);
        dtm.setRowCount(0);

        List<Order> list = os.getAll();

        if(list == null || list.size() == 0){
            return;
        }
        int len = list.size();
        Object[][] res = new Object[len][10];
        for(Order t :list){
            res[0][0] = t.getId();
            res[0][1] = t.getMch_id();
            res[0][2] = t.getOut_trade_no();
            res[0][3] = t.getTransaction_id();
            res[0][4] = t.getStart_time();
            res[0][5] = t.getUsername();
            res[0][6] = t.getList();
            res[0][7] = t.getAmount();
            res[0][8] = t.getStatus();
            res[0][9] = t.getRemark();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    void selectOrderByStatus(int status){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForOwner_Order);
        dtm.setRowCount(0);

        List<Order> list = os.getOrdersByStatus(status);
        if(list == null || list.size() == 0){
            return;
        }

        int len = list.size();
        Object[][] res = new Object[len][10];
        for(Order t :list){
            res[0][0] = t.getId();
            res[0][1] = t.getMch_id();
            res[0][2] = t.getOut_trade_no();
            res[0][3] = t.getTransaction_id();
            res[0][4] = t.getStart_time();
            res[0][5] = t.getUsername();
            res[0][6] = t.getList();
            res[0][7] = t.getAmount();
            res[0][8] = t.getStatus();
            res[0][9] = t.getRemark();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();

    }

    Order getOrder(int row){
        int id = Integer.valueOf(table1.getValueAt(row,0).toString());
        int mch_id = Integer.parseInt(table1.getValueAt(row,1).toString());
        String out_trade_no = table1.getValueAt(row,2).toString();
        String transaction_id = table1.getValueAt(row,3).toString();
        Timestamp start_time = (Timestamp) table1.getValueAt(row,4);
        String username = table1.getValueAt(row,5).toString();
        String list = table1.getValueAt(row,6).toString();
        double amount = Double.parseDouble(table1.getValueAt(row,7).toString());
        int status = Integer.parseInt(table1.getValueAt(row,8).toString());
        String remark = table1.getValueAt(row,9).toString();

        Order order = new Order(id,mch_id,out_trade_no,transaction_id,start_time,username,list,amount,status,remark);

        return order;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm;
    private OrderService os = new OrderServiceImpl();
}
