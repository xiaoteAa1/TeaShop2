/*
 * Created by JFormDesigner on Tue Apr 26 17:35:07 CST 2022
 */

package org.example.controller.shopper.tea_manage;

import org.example.controller.shopper.ShopperEnter;
import org.example.domain.Tea;
import org.example.service.TeaService;
import org.example.service.impl.TeaServiceImpl;
import org.example.utils.SwingUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 消费者使用购物车
 * @author LXJ
 */
public class ShopperBuy extends JFrame {
    public ShopperBuy() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("shopper-Shopping!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 35, 450, 300);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(500, 35, 350, 300);

        //---- button1 ----
        button1.setText("\u5237\u65b0");
        contentPane.add(button1);
        button1.setBounds(100, 0, 80, 32);

        //---- label1 ----
        label1.setText("\u603b\u91d1\u989d\uff1a");
        contentPane.add(label1);
        label1.setBounds(740, 10, 60, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("0");
        contentPane.add(label2);
        label2.setBounds(795, 10, 90, label2.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u7ed3\u7b97");
        contentPane.add(button2);
        button2.setBounds(780, 335, 73, 45);

        //---- button3 ----
        button3.setText("\u8fd4\u56de");
        contentPane.add(button3);
        button3.setBounds(15, 0, 80, 32);

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
        setSize(925, 475);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //1、加载所有可销售奶茶
        button1.addActionListener((e) -> {
                getAllTea();
        });

        //2、商品结算
        button2.addActionListener((e) -> {
            pay();
        });

        //3、返回上一级
        button3.addActionListener((e) -> {
            this.setVisible(false);

            ShopperEnter sb = new ShopperEnter();
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        });


        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting())return;//让该事件只触发一次

                int selectedRow = table1.getSelectedRow();
                if(selectedRow == -1)return;

                //获取选中行的奶茶名称、奶茶数量、奶茶价格
                String name = (String)table1.getValueAt(selectedRow, 1);
                int count = Integer.parseInt(table1.getValueAt(selectedRow, 4).toString());
                double price = Double.valueOf(table1.getValueAt(selectedRow, 2).toString());

                //尝试将奶茶添加到购物车中
                addTeaToTable2(name,count,price);

                table1.clearSelection();
            }
        });

        table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting())return;//让该事件只触发一次

                int selectedRow = table2.getSelectedRow();
                if(selectedRow == -1)return;

                double newPrice = Double.valueOf(label2.getText()) - Double.valueOf(table2.getValueAt(selectedRow,2).toString());

                label2.setText(newPrice+"");

                DefaultTableModel model = (DefaultTableModel)table2.getModel();
                model.removeRow(selectedRow);
            }
        });
    }

    void pay(){
        //1、判断是否有商品！
        if(table2.getRowCount() == 0 && label2.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"请选择商品！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //2、打开支付页面
        Payment payment = new Payment(getList()[0],getList()[1],Double.parseDouble(label2.getText()));
        payment.setVisible(true);

        System.out.println("我结束了");
    }

    /**
     * 获得购物车中的商品字符串
     * @return list
     */
    String[] getList(){
        String[] arr = new String[2];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int len = table2.getRowCount();
        for(int i = 0;i < len;i++){
            String name = table2.getValueAt(i, 0).toString();
            String count = table2.getValueAt(i, 1).toString();

            sb1.append(name + " " + count +"\n");

            if(i != len-1){
                sb2.append(name + " " + count + " ");
            }else{
                sb2.append(name + " " + count);
            }
        }
        arr[0] = sb1.toString();
        arr[1] = sb2.toString();

        return arr;
    }

    void addTeaToTable2(String name,int count,double price){
        if(count == 0){
            JOptionPane.showMessageDialog(null,"库存不足！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return;
        }

        int rowCount = table2.getRowCount();
        for(int i = 0;i < rowCount;i++){
            if(table2.getValueAt(i,0).equals(name)){
                //1、数量大于库存，不行！
                int newCount = Integer.valueOf(table2.getValueAt(i,1).toString())+1;
                if(newCount > count){
                    JOptionPane.showMessageDialog(null,"库存不足！",
                            "提示",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                table2.setValueAt(newCount,i,1);
                table2.setValueAt(Double.valueOf(table2.getValueAt(i,2).toString())+price,i,2);

                //更新总价格
                label2.setText(Double.valueOf(label2.getText())+price+"");
                return;
            }
        }

        //当前奶茶第一次出现在购物车
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.addRow(new Object[]{ name, 1,price});

        //更新总价格
        label2.setText(Double.valueOf(label2.getText())+price+"");
    }

    void getAllTea(){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopper);
        dtm.setRowCount(0);

        List<Tea> list = ts.getAllTeaOnSale();
        int len = list.size();
        Object[][] res = new Object[len][SwingUtils.columnsForShopper.length];

        int idx = 0,cnt = 0;
        for(Tea t :list){
            res[idx][0] = ++cnt;
            res[idx][1] = t.getName();
            res[idx][2] = t.getPrice();
            res[idx][3] = t.getType();
            res[idx][4] = t.getCount();
            res[idx][5] = t.getRemark();
            dtm.addRow(res[idx]);
        }
        table1.setModel(dtm);
        table1.invalidate();

        //===table2===
        DefaultTableModel dtm2 = new DefaultTableModel(null,SwingUtils.columnsForShoppingCart);
        dtm2.setRowCount(0);

        table2.setModel(dtm2);
        table2.invalidate();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm;
    private TeaService ts = new TeaServiceImpl();

}