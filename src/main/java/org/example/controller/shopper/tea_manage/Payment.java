/*
 * Created by JFormDesigner on Fri Apr 29 10:33:26 CST 2022
 */

package org.example.controller.shopper.tea_manage;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Payment extends JFrame {
    public Payment(String listShow,String list,double amount) {
        this.listShow = listShow;
        this.list = list;
        this.amount = amount;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        label4 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label5 = new JLabel();

        //======== this ========
        setTitle("counter");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u60a8\u7684\u6635\u79f0\uff1a");
        contentPane.add(label1);
        label1.setBounds(60, 30, 75, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(130, 20, 110, 35);

        //---- label2 ----
        label2.setText("\u652f\u4ed8\u65b9\u5f0f\uff1a");
        contentPane.add(label2);
        label2.setBounds(60, 75, 75, 17);
        contentPane.add(comboBox1);
        comboBox1.setBounds(130, 70, 110, 35);

        //---- label3 ----
        label3.setText("\u603b\u91d1\u989d\uff1a");
        contentPane.add(label3);
        label3.setBounds(60, 115, 75, 17);

        //---- label4 ----
        label4.setText("text");
        contentPane.add(label4);
        label4.setBounds(135, 120, 90, label4.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u7acb\u5373\u652f\u4ed8");
        contentPane.add(button1);
        button1.setBounds(185, 290, 95, 50);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(135, 160, 125, 120);

        //---- label5 ----
        label5.setText("\u8ba2\u5355\u5217\u8868\uff1a");
        contentPane.add(label5);
        label5.setBounds(60, 155, 75, 17);

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
        setSize(320, 390);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        comboBox1.addItem("");
        comboBox1.addItem("微信扫码支付");
        comboBox1.addItem("付款码支付");
        label4.setText(amount+"");
        textArea1.setText(listShow);

        button1.addActionListener((e) -> {
            String item = comboBox1.getSelectedItem().toString();

            if(item.equals("微信扫码支付")){
                boolean b = wxPay();
            }else if(item.equals("付款码支付")){

            }else{
                JOptionPane.showMessageDialog(null,"请选择支付方式！",
                        "提示",JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    boolean wxPay(){
        //1、弹出微信支付界面
        WXPay wp = new WXPay();
        wp.setVisible(true);

        return true;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private String listShow;
    private String list;
    private double amount;
}
