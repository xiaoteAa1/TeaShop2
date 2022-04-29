/*
 * Created by JFormDesigner on Wed Apr 27 21:20:15 CST 2022
 */

package org.example.controller.shopper.order_manage;

import org.example.controller.shopper.ShopperEnter;
import org.example.domain.Order;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceImpl;
import org.example.utils.SwingUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class ShopperOrder extends JFrame {
    public ShopperOrder() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        comboBox1 = new JComboBox();

        //======== this ========
        setTitle("shopper-OrderManagement");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 40, 685, 375);

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        contentPane.add(button1);
        button1.setBounds(5, 5, 80, 32);
        contentPane.add(comboBox1);
        comboBox1.setBounds(95, 5, 110, 32);

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
        setSize(715, 465);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        comboBox1.addItem("");
        comboBox1.addItem("当前订单");
        comboBox1.addItem("已完成订单");
        comboBox1.addItem("所有订单");


        //1、返回上一级功能
        button1.addActionListener((e) -> {
            this.setVisible(false);

            ShopperEnter sb = new ShopperEnter();
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });


        //2、显示订单
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
                    default:
                        break;
                }
            }
        });
    }

    void selectAllOrder(){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopper_Order);
        dtm.setRowCount(0);

        List<Order> list = os.getAll();

        if(list == null || list.size() == 0){
            return;
        }

        int len = list.size();
        Object[][] res = new Object[len][7];
        int idx = 1;
        for(Order t :list){
            res[0][0] = idx++;
            res[0][1] = t.getStart_time();
            res[0][2] = t.getUsername();
            res[0][3] = t.getList();
            res[0][4] = t.getAmount();
            res[0][5] = t.getStatus();
            res[0][6] = t.getRemark();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    void selectOrderByStatus(int status){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopper_Order);
        dtm.setRowCount(0);

        List<Order> list = os.getOrdersByStatus(status);
        if(list == null || list.size() == 0){
            return;
        }

        int len = list.size();
        Object[][] res = new Object[len][7];
        int idx = 1;
        for(Order t :list){
//            res[0][0] = t.getId();
            res[0][0] = idx++;
            res[0][1] = t.getStart_time();
            res[0][2] = t.getUsername();
            res[0][3] = t.getList();
            res[0][4] = t.getAmount();
            res[0][5] = t.getStatus();
            res[0][6] = t.getRemark();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm;
    private OrderService os = new OrderServiceImpl();
}
