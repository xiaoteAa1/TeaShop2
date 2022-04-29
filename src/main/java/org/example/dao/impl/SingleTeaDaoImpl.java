package org.example.dao.impl;

import org.example.dao.SingleTeaDao;
import org.example.domain.SingleTea;
import org.example.utils.JDBCUtils;

import java.sql.*;

public class SingleTeaDaoImpl implements SingleTeaDao {
    Connection conn;
    PreparedStatement psta;
    Statement sta;
    ResultSet rs;


    @Override
    public SingleTea getTeaByName(String name) {
        SingleTea tea = null;
        try {
            String sql = "SELECT * FROM tea WHERE name=?";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setString(1,name);

            rs = psta.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");

                tea = new SingleTea(id,name,price,type,isSale,remark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }

        return tea;
    }


    @Override
    public boolean addTea(SingleTea tea) {
        try {
            String sql = "Insert Into tea (name,price,type,isSale,remark) " +
                    "Values (?,?,?,?,?)";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);

            psta.setString(1,tea.getName());
            psta.setDouble(2,tea.getPrice());
            psta.setString(3,tea.getType());
            psta.setInt(4,tea.getIsSale());
            psta.setString(5,tea.getRemark());

            int i = psta.executeUpdate();

            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(rs,psta,conn);
        }
    }

    @Override
    public boolean updateTea(int id, String name, double price, String type, int isSale, String remark) {
        int res = 0;
        try {
            String sql = "UPDATE tea SET name=?,price=?,type=?,isSale=?,remark=? WHERE id=?";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setString(1,name);
            psta.setDouble(2,price);
            psta.setString(3,type);
            psta.setInt(4,isSale);
            psta.setString(5,remark);
            psta.setInt(6,id);

            res = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, sta,conn);
        }

        return res > 0;
    }

    @Override
    public boolean deleteTeaById(int id) {
        int res = 0;
        try {
            String sql = "DELETE FROM tea WHERE id=?";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setInt(1,id);

            res = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, sta,conn);
        }

        return res > 0;
    }

}
