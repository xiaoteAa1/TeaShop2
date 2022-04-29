/*
 * Created by JFormDesigner on Thu Apr 28 20:11:38 CST 2022
 */

package org.example.controller.shop_owner.order_manage;

import org.example.domain.Order;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceImpl;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class OrderUpdate extends JFrame {
    public OrderUpdate(Order order) {
        root = order;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        textField6 = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label8 = new JLabel();
        label9 = new JLabel();
        textArea2 = new JTextArea();
        label10 = new JLabel();
        button1 = new JButton();
        label11 = new JLabel();
        textField7 = new JTextField();

        //======== this ========
        setTitle("OrderUpdate");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8ba2\u5355\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(45, 30, 75, label1.getPreferredSize().height);

        //---- textField1 ----
        textField1.setEditable(false);
        contentPane.add(textField1);
        textField1.setBounds(110, 25, 85, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5546\u6237id\uff1a");
        contentPane.add(label2);
        label2.setBounds(45, 70, 75, 17);

        //---- textField2 ----
        textField2.setEditable(false);
        contentPane.add(textField2);
        textField2.setBounds(110, 65, 130, 30);

        //---- label3 ----
        label3.setText("\u5546\u6237id\uff1a");
        contentPane.add(label3);
        label3.setBounds(45, 110, 75, 17);

        //---- textField3 ----
        textField3.setEditable(false);
        contentPane.add(textField3);
        textField3.setBounds(110, 105, 130, 30);

        //---- label4 ----
        label4.setText("\u4ea4\u6613\u53f7\uff1a");
        contentPane.add(label4);
        label4.setBounds(45, 150, 75, 17);

        //---- textField4 ----
        textField4.setEditable(false);
        contentPane.add(textField4);
        textField4.setBounds(110, 145, 130, 30);

        //---- label5 ----
        label5.setText("\u53d1\u8d77\u65f6\u95f4\uff1a");
        contentPane.add(label5);
        label5.setBounds(45, 190, 75, 17);

        //---- textField5 ----
        textField5.setEditable(false);
        contentPane.add(textField5);
        textField5.setBounds(110, 185, 130, 30);

        //---- textField6 ----
        textField6.setEditable(false);
        contentPane.add(textField6);
        textField6.setBounds(350, 65, 130, 30);

        //---- label6 ----
        label6.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label6);
        label6.setBounds(285, 65, 75, 17);

        //---- label7 ----
        label7.setText("\u8ba2\u5355\u5217\u8868\uff1a");
        contentPane.add(label7);
        label7.setBounds(285, 105, 75, 17);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setWrapStyleWord(true);
            textArea1.setEditable(false);
            textArea1.setLineWrap(true);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(350, 105, 150, 140);

        //---- label8 ----
        label8.setText("\u603b\u91d1\u989d\uff1a");
        contentPane.add(label8);
        label8.setBounds(410, 255, 75, 17);

        //---- label9 ----
        label9.setText("\u5907\u6ce8\uff1a");
        contentPane.add(label9);
        label9.setBounds(45, 235, 75, 17);

        //---- textArea2 ----
        textArea2.setWrapStyleWord(true);
        textArea2.setLineWrap(true);
        contentPane.add(textArea2);
        textArea2.setBounds(110, 235, 148, 138);

        //---- label10 ----
        label10.setText("text");
        contentPane.add(label10);
        label10.setBounds(475, 255, 50, label10.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5b8c\u7ed3\u8ba2\u5355");
        contentPane.add(button1);
        button1.setBounds(425, 310, 80, 65);

        //---- label11 ----
        label11.setText("\u8ba2\u5355\u72b6\u6001\uff1a");
        contentPane.add(label11);
        label11.setBounds(285, 30, 75, 17);

        //---- textField7 ----
        textField7.setEditable(false);
        contentPane.add(textField7);
        textField7.setBounds(350, 25, 130, 30);

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
        setSize(545, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        textField1.setText(root.getId()+"");
        textField2.setText(root.getMch_id()+"");
        textField3.setText(root.getOut_trade_no());
        textField4.setText(root.getTransaction_id());
        textField5.setText(root.getStart_time().toString());
        textArea1.setText(root.getList());
        textField7.setText(root.getStatus()+"");
        textField6.setText(root.getUsername());
        textArea2.setText(root.getRemark());

        label10.setText(root.getAmount()+"");

        if(root.getStatus() != 0){
            button1.setText("修改");
        }else{
            button1.setText("完结");
        }

        button1.addActionListener((e) -> {
            if(root.getStatus() == 0){
                boolean b = finishOrder();
                //完结成功！
                if(b){
                    this.setVisible(false);
                }
            }else {
                boolean b = updateOrder();
                //修改成功！
                if(b){
                    this.setVisible(false);
                }
            }
        });

    }

    /**
     * 完结订单
     */
    boolean finishOrder(){
        //1、提示用户是否要完结
        int i = JOptionPane.showConfirmDialog(null, "是否完结此订单？", "完结订单",
                JOptionPane.YES_NO_OPTION);
        //i == 0才更新
        if(i == 1){
            //不更新
            return false;
        }

        //2、开始完结
        boolean b = os.updateOrderStatusTo1(root.getId());
        if(b){
            JOptionPane.showMessageDialog(null,"完结成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"完结失败，请稍后重试！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        return b;
    }

    /**
     * 修改订单信息
     * 暂时只能修改订单备注
     */
    boolean updateOrder(){
        //1、检查备注是否修改
        if(textArea2.getText().equals(root.getRemark())){
            JOptionPane.showMessageDialog(null,"未检测到内容修改！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        //2、提示用户是否要完结
        int i = JOptionPane.showConfirmDialog(null, "是否修改订单信息？", "修改订单",
                JOptionPane.YES_NO_OPTION);
        //i == 0才更新
        if(i == 1){
            //不更新
            return false;
        }

        //3、开始完结
        boolean b = os.updateOrderRemark(root.getId(),textArea2.getText());
        if(b){
            JOptionPane.showMessageDialog(null,"完结成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"完结失败，请稍后重试！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        return b;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label6;
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label8;
    private JLabel label9;
    private JTextArea textArea2;
    private JLabel label10;
    private JButton button1;
    private JLabel label11;
    private JTextField textField7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private OrderService os = new OrderServiceImpl();
    private Order root;
}
