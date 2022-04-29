/*
 * Created by JFormDesigner on Wed Apr 27 22:33:53 CST 2022
 */

package org.example.controller.shop_owner.tea_manage;

import org.example.domain.Tea;
import org.example.service.TeaService;
import org.example.service.impl.TeaServiceImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author 1
 */
public class TeaUpdateDel extends JFrame {
    public TeaUpdateDel(Tea tea) {
        node = tea;
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
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label7 = new JLabel();
        label8 = new JLabel();
        textField6 = new JTextField();
        textField7 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Tea");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5976\u8336\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(15, 15, 75, label1.getPreferredSize().height);

        //---- textField1 ----
        textField1.setEditable(false);
        contentPane.add(textField1);
        textField1.setBounds(90, 10, 90, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5976\u8336\u540d\u79f0\uff1a");
        contentPane.add(label2);
        label2.setBounds(15, 50, 75, 17);
        contentPane.add(textField2);
        textField2.setBounds(90, 45, 150, 30);

        //---- label3 ----
        label3.setText("\u5976\u8336\u4ef7\u683c\uff1a");
        contentPane.add(label3);
        label3.setBounds(15, 85, 75, 17);
        contentPane.add(textField3);
        textField3.setBounds(90, 80, 150, 30);

        //---- label4 ----
        label4.setText("\u5976\u8336\u7c7b\u578b\uff1a");
        contentPane.add(label4);
        label4.setBounds(15, 120, 80, 17);
        contentPane.add(textField4);
        textField4.setBounds(90, 115, 150, 30);

        //---- label5 ----
        label5.setText("\u9500\u552e\u72b6\u6001\uff1a");
        contentPane.add(label5);
        label5.setBounds(15, 155, 75, 17);
        contentPane.add(textField5);
        textField5.setBounds(90, 150, 150, 30);

        //---- label6 ----
        label6.setText("\u5976\u8336\u5907\u6ce8\uff1a");
        contentPane.add(label6);
        label6.setBounds(15, 190, 75, 17);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setWrapStyleWord(true);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(95, 195, 145, 115);

        //---- label7 ----
        label7.setText("\u5976\u8336\u5e93\u5b58\uff1a");
        contentPane.add(label7);
        label7.setBounds(260, 15, 70, 17);

        //---- label8 ----
        label8.setText("\u603b\u9500\u91cf\uff1a");
        contentPane.add(label8);
        label8.setBounds(260, 50, 70, 17);
        contentPane.add(textField6);
        textField6.setBounds(335, 10, 90, 30);

        //---- textField7 ----
        textField7.setEditable(false);
        contentPane.add(textField7);
        textField7.setBounds(335, 45, 90, 30);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(310, 310, 83, 45);

        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(395, 310, 83, 45);

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
        setSize(505, 405);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        textField1.setText(node.getTeaId()+"");
        textField2.setText(node.getName()+"");
        textField3.setText(node.getPrice()+"");
        textField4.setText(node.getType()+"");
        textField5.setText(node.getIsSale()+"");
        textArea1.setText(node.getRemark());

        textField6.setText(node.getCount()+"");
        textField7.setText(node.getSales()+"");

        //1、更新操作
        button1.addActionListener((e) -> {
            boolean b = update();
            if(b){
                this.setVisible(false);//修改成功！
            }
        });

        //2、删除操作
        button2.addActionListener((e) -> {
            boolean b = delete();
            if(b){
                this.setVisible(false);
            }
        });
    }

    boolean update(){
        //1、如果内容都没有修改，则不进行操作
        if( (node.getName().equals(textField2.getText())) &&
                (node.getPrice() == Double.valueOf(textField3.getText())) &&
                (node.getType().equals(textField4.getText())) &&
                (node.getIsSale() == Integer.parseInt(textField5.getText())) &&
                (node.getRemark().equals(textArea1.getText())) &&
                (node.getCount()== Integer.parseInt(textField6.getText()))
        ){
            JOptionPane.showMessageDialog(null,"内容没有更改！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        //2、判断修改后内容是否合法
        if(textField2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"奶茶名称不能为空！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(textField3.getText().equals("")){
            JOptionPane.showMessageDialog(null,"奶茶价格不能为空！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(Double.parseDouble(textField3.getText()) < 0){
            JOptionPane.showMessageDialog(null,"奶茶名称不能为负数！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(textField4.getText().equals("")){
            textField4.setText("其它");
        }
        if(!(textField5.getText().equals("1") || textField5.getText().equals("0"))){
            JOptionPane.showMessageDialog(null,"销售状态只能填0或1(0不可销售，1可销售)！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(textField6.getText().equals("")){
            JOptionPane.showMessageDialog(null,"请填写库存！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(Integer.parseInt(textField6.getText()) < 0){
            JOptionPane.showMessageDialog(null,"库存数量不能为负数！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        //3、提示用户是否修改
        int i = JOptionPane.showConfirmDialog(null, "是否确认更新？", "更新奶茶信息",
                JOptionPane.YES_NO_OPTION);
        //i == 0才更新
        if(i == 1){
            //不更新
            return false;
        }

        //4、开始修改
        boolean res = ts.updateAll(node.getTeaId(),
                textField2.getText().trim(),
                Double.valueOf(textField3.getText()),
                textField4.getText(),
                Integer.parseInt(textField5.getText()),
                textArea1.getText(),
                Integer.parseInt(textField6.getText()));


        if(res){
            JOptionPane.showMessageDialog(null,"更新成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"更新失败，请稍后重试！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        return res;
    }

    boolean delete(){
        //1、向用户再次确认是否删除
        int i = JOptionPane.showConfirmDialog(null, "是否确认删除？", "删除奶茶信息",
                JOptionPane.YES_NO_OPTION);
        //i == 0才更新
        if(i == 1){
            //不更新
            return false;
        }

        //2、开始删除
        boolean b = ts.deleteTea(node.getTeaId());
        if(b){
            JOptionPane.showMessageDialog(null,"删除成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"删除失败，请稍后重试！",
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
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField6;
    private JTextField textField7;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Tea node;
    private TeaService ts = new TeaServiceImpl();
}
