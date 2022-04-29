/*
 * Created by JFormDesigner on Wed Apr 27 22:24:21 CST 2022
 */

package org.example.controller.shop_owner;

import org.example.controller.Login;
import org.example.controller.shop_owner.order_manage.OrderController;
import org.example.controller.shop_owner.tea_manage.TeaController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author 1
 */
public class OwnerEnter extends JFrame {
    public OwnerEnter() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("owner-Enter");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u5976\u8336\u67e5\u770b");
        contentPane.add(button1);
        button1.setBounds(135, 55, 110, 50);

        //---- button2 ----
        button2.setText("\u8ba2\u5355\u67e5\u770b");
        contentPane.add(button2);
        button2.setBounds(135, 125, 110, 50);

        //---- button4 ----
        button4.setText("\u8fd4\u56de");
        contentPane.add(button4);
        button4.setBounds(10, 10, 80, 32);

        //---- button3 ----
        button3.setText("\u7edf\u8ba1\u9762\u677f");
        contentPane.add(button3);
        button3.setBounds(135, 195, 110, 50);

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
        setSize(390, 345);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //1、去往奶茶管理
        button1.addActionListener((e) ->{
            this.setVisible(false);

            TeaController btc = new TeaController();
            btc.setVisible(true);
            btc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        });

        //2、去往订单管理
        button2.addActionListener((e) ->{
            this.setVisible(false);

            OrderController oc = new OrderController();
            oc.setVisible(true);
            oc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });


        //3、返回上一级
        button4.addActionListener((e) -> {
            this.setVisible(false);

            Login login = new Login();
            login.setVisible(true);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
