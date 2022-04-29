/*
 * Created by JFormDesigner on Mon Apr 18 19:01:00 CST 2022
 */

package org.example.controller.shop_owner.tea_manage;


import org.example.controller.shop_owner.OwnerEnter;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 *@author  LXJ
 *@date    2022/04/18 16:08
 */
public class TeaController extends JFrame {
    public TeaController() {
        initComponents();
    }

    private void button2KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        button4 = new JButton();
        textField3 = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();

        //======== this ========
        setTitle("owner-TeaManagement");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 80, 730, 385);

        //---- button1 ----
        button1.setText("\u6240\u6709\u5976\u8336");
        contentPane.add(button1);
        button1.setBounds(95, 5, 90, 32);

        //---- button2 ----
        button2.setText("\u67e5\u627e");
        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button2KeyPressed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(400, 5, 70, 30);

        //---- button3 ----
        button3.setText("\u67e5\u627e");
        contentPane.add(button3);
        button3.setBounds(615, 5, 70, 30);
        contentPane.add(textField1);
        textField1.setBounds(320, 5, 75, 30);

        //---- label1 ----
        label1.setText("ID:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(300, 10), label1.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(535, 5, 75, 30);

        //---- label2 ----
        label2.setText("Name:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(495, 10), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("type:");
        contentPane.add(label3);
        label3.setBounds(10, 45, 34, label3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("\u67e5\u627e");
        contentPane.add(button4);
        button4.setBounds(140, 40, 70, 30);
        contentPane.add(textField3);
        textField3.setBounds(45, 40, 90, 30);

        //---- button5 ----
        button5.setText("\u5728\u552e\u5976\u8336");
        contentPane.add(button5);
        button5.setBounds(185, 5, 90, 32);

        //---- button6 ----
        button6.setText("\u8fd4\u56de");
        contentPane.add(button6);
        button6.setBounds(0, 5, 80, 32);

        //---- button7 ----
        button7.setText("\u6dfb\u52a0\u5976\u8336");
        contentPane.add(button7);
        button7.setBounds(650, 35, 85, 40);

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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //1、获取所有奶茶信息，展示到表格中
        button1.addActionListener((e) -> {
            getAllTea();
        });

        //2、根据id筛选奶茶
        button2.addActionListener((e) -> {
            if(textField1.getText() != "")
                getTeaById(Integer.parseInt(textField1.getText()));
        });

        //3、根据奶茶名称筛选奶茶
        button3.addActionListener((e) -> {
            if(textField2.getText() != "")
                getTeaByName(textField2.getText());
        });

        //4、根据奶茶类型筛选奶茶
        button4.addActionListener((e) -> {
            if(textField3.getText() != "")
                getAllTeaByType(textField3.getText());
        });

        //5、获得正在销售的奶茶
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllTeaOnSale();
            }
        });

        //6、返回上一级
        button6.addActionListener((e) ->{
            this.setVisible(false);

            OwnerEnter oe = new OwnerEnter();
            oe.setVisible(true);
            oe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        //7、添加奶茶
        button7.addActionListener((e) -> {

            TeaAdd ta = new TeaAdd();
            ta.setVisible(true);
        });

        //为表格添加点击行事件
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if(e.getValueIsAdjusting() || selectedRow == -1)return;

                //通过名称获得奶茶
                String teaName = table1.getValueAt(selectedRow, 1).toString();

                //获取到选择的列
                TeaUpdateDel td = new TeaUpdateDel(getTea(selectedRow));
                td.setVisible(true);

                table1.clearSelection();
            }
        });
    }

    //根据ID搜索：
    void getTeaById(int id){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopOwner_Tea);
        dtm.setRowCount(0);

        Tea t = ts.getTeaById(id);
        //如果没有指定id的奶茶
        if(t == null){
            System.out.println("查无此奶茶！");
            return;
        }

        Object[][] res = new Object[1][8];
        res[0][0] = t.getTeaId();
        res[0][1] = t.getName();
        res[0][2] = t.getPrice();
        res[0][3] = t.getType();
        res[0][4] = t.getIsSale();
        res[0][5] = t.getRemark();
        res[0][6] = t.getCount();
        res[0][7] = t.getSales();

        dtm.addRow(res[0]);
        table1.setModel(dtm);
        table1.invalidate();
    }

    //根据名字搜索：
    void getTeaByName(String name){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopOwner_Tea);
        dtm.setRowCount(0);
        Tea t = ts.getTeaByName(name);

        //如果没有指定名字的奶茶
        if(t == null){
            System.out.println("查无此奶茶！");
            return;
        }

        Object[][] res = new Object[1][8];
        res[0][0] = t.getTeaId();
        res[0][1] = t.getName();
        res[0][2] = t.getPrice();
        res[0][3] = t.getType();
        res[0][4] = t.getIsSale();
        res[0][5] = t.getRemark();
        res[0][6] = t.getCount();
        res[0][7] = t.getSales();

        dtm.addRow(res[0]);
        table1.setModel(dtm);
        table1.invalidate();
    }

    void getAllTeaByType(String type){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopOwner_Tea);
        dtm.setRowCount(0);

        List<Tea> list = ts.getTeasByType(type);
        if(list == null || list.size() == 0){
            System.out.println("结果为空！");
            return;
        }

        int len = list.size();
        Object[][] res = new Object[len][8];
        for(Tea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            res[0][4] = t.getIsSale();
            res[0][5] = t.getRemark();
            res[0][6] = t.getCount();
            res[0][7] = t.getSales();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();

    };

    void getAllTeaOnSale(){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopOwner_Tea);
        dtm.setRowCount(0);
        List<Tea> list = ts.getAllTeaOnSale();
        if(list == null || list.size() == 0){
            return;
        }

        int len = list.size();
        Object[][] res = new Object[len][8];
        for(Tea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            res[0][4] = t.getIsSale();
            res[0][5] = t.getRemark();
            res[0][6] = t.getCount();
            res[0][7] = t.getSales();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    };

    void getAllTea(){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopOwner_Tea);
        dtm.setRowCount(0);
        List<Tea> list = ts.getAllTea();
        if(list == null || list.size() == 0){
            return;
        }

        int len = list.size();
        Object[][] res = new Object[len][8];
        for(Tea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            res[0][4] = t.getIsSale();
            res[0][5] = t.getRemark();
            res[0][6] = t.getCount();
            res[0][7] = t.getSales();
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    //将第row行的数据转换成Tea对象
    Tea getTea(int row){
        int id = Integer.valueOf(table1.getValueAt(row,0).toString());
        String teaName = table1.getValueAt(row, 1).toString();
        double price = Double.parseDouble(table1.getValueAt(row, 2).toString());
        String type = table1.getValueAt(row, 3).toString();
        int isSale = Integer.parseInt(table1.getValueAt(row, 4).toString());
        String remark = table1.getValueAt(row, 5).toString();
        int remain = Integer.parseInt(table1.getValueAt(row, 6).toString());
        int sale = Integer.parseInt(table1.getValueAt(row, 7).toString());

        Tea tea = new Tea(id,teaName,price,type,isSale,remark,remain,sale);

        return tea;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JLabel label1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JButton button4;
    private JTextField textField3;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm;
    private TeaService ts = new TeaServiceImpl();

    public static void main(String[] args) {
        dtm = new DefaultTableModel(null,SwingUtils.columnsForShopper);
        new TeaController();
    }
}