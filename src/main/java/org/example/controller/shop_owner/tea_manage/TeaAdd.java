/*
 * Created by JFormDesigner on Thu Apr 28 11:04:50 CST 2022
 */

package org.example.controller.shop_owner.tea_manage;

import org.example.domain.Tea;
import org.example.service.TeaService;
import org.example.service.impl.TeaServiceImpl;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class TeaAdd extends JFrame {
    public TeaAdd() {
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
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label6 = new JLabel();

        //======== this ========
        setTitle("TeaAdd");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5976\u8336\u540d\u79f0\uff1a");
        contentPane.add(label1);
        label1.setBounds(60, 25, 80, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(135, 20, 120, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5976\u8336\u4ef7\u683c\uff1a");
        contentPane.add(label2);
        label2.setBounds(60, 65, 80, 17);
        contentPane.add(textField2);
        textField2.setBounds(135, 60, 120, 30);

        //---- label3 ----
        label3.setText("\u5976\u8336\u7c7b\u578b\uff1a");
        contentPane.add(label3);
        label3.setBounds(60, 105, 80, 17);
        contentPane.add(textField3);
        textField3.setBounds(135, 100, 120, 30);

        //---- label4 ----
        label4.setText("\u9500\u552e\u72b6\u6001\uff1a");
        contentPane.add(label4);
        label4.setBounds(60, 145, 80, 17);
        contentPane.add(textField4);
        textField4.setBounds(135, 140, 120, 30);

        //---- label5 ----
        label5.setText("\u5e93\u5b58\u6570\u91cf\uff1a");
        contentPane.add(label5);
        label5.setBounds(60, 185, 80, 17);
        contentPane.add(textField5);
        textField5.setBounds(135, 180, 120, 30);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(180, 360, 80, 45);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setWrapStyleWord(true);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(135, 230, 120, 120);

        //---- label6 ----
        label6.setText("\u5907\u6ce8\u4fe1\u606f\uff1a");
        contentPane.add(label6);
        label6.setBounds(60, 225, 80, 17);

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
        setSize(360, 480);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        button1.addActionListener((e)->{
            boolean b = add();
            if(b){
                this.setVisible(false);
            }
        });
    }

    boolean add(){
        //1、判断填写内容是否合法
        String name = textField1.getText();
        String price = textField2.getText();
        String type = textField3.getText();
        String isSale = textField4.getText();
        String remark = textArea1.getText();
        String remain = textField5.getText();

        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"奶茶名称未填写！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(price.equals("")){
            JOptionPane.showMessageDialog(null,"奶茶价格未填写！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(type.equals("")){
            textField3.setText("其它");
        }
        if(isSale.equals("")){
            JOptionPane.showMessageDialog(null,"请填写销售状态0或1(0表示不销售，1表示销售)！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!(isSale.equals("1") || isSale.equals("0"))){
            JOptionPane.showMessageDialog(null,"销售状态只能填写0或1(0表示不销售，1表示销售)！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(remain.equals("")){
            JOptionPane.showMessageDialog(null,"请填写库存数量！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        //2、提示用户是否确认添加
        int i = JOptionPane.showConfirmDialog(null, "是否确认添加？", "添加奶茶信息",
                JOptionPane.YES_NO_OPTION);
        //i == 0才更新
        if(i == 1){
            //不更新
            return false;
        }

        //3、开始添加
        Tea tea = new Tea(name,Double.parseDouble(price),type,Integer.parseInt(isSale),remark,Integer.parseInt(remain));
        boolean b = ts.addTea(tea);

        if(b){
            JOptionPane.showMessageDialog(null,"添加成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"添加失败，请稍后重试！",
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
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TeaService ts = new TeaServiceImpl();
}
