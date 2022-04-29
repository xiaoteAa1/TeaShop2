package org.example.dao.impl;

import org.example.dao.StoreDao;
import org.example.domain.Tea;
import org.example.utils.JDBCUtils;

import java.sql.*;

public class StoreDaoImpl implements StoreDao {
    Connection conn;
    PreparedStatement psta;
    Statement sta;
    ResultSet rs;

    /**
     * 通过teaId获得其库存数量
     * @param teaId
     * @return
     */
    @Override
    public int getTeaStoreById(int teaId) {
        int count = 0;

        try {
            String sql = "SELECT count FROM store WHERE teaId=?";
            conn = JDBCUtils.getConnection();

            psta = conn.prepareStatement(sql);
            psta.setInt(1,teaId);

            rs = psta.executeQuery();
            if(!rs.next()){//判断teaId是否存在
                return 0;
            }
            count = rs.getInt("count");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }

        return count;
    }

    /**
     * 通过teaId，使该tea的库存为store
     * @param teaId
     * @return
     */
    @Override
    public boolean addTeaStore(int teaId, int store) {
        int res = 0;
        try {
            String sql = "INSERT INTO store(teaId,count) VALUES(?,?)";
            conn = JDBCUtils.getConnection();
            System.out.println(teaId);

            psta = conn.prepareStatement(sql);
            psta.setInt(1,teaId);
            psta.setInt(2,store);

            res = psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }

        return res > 0;
    }

    /**
     * 使指定id的库存数量替换为newValue
     * @param teaId
     * @param newValue
     * @return
     */
    @Override
    public boolean updateTeaStore(int teaId, int newValue) {
        int res = 0;
        try {
            String sql = "UPDATE store SET count=? WHERE teaId=?";
            conn = JDBCUtils.getConnection();

            psta = conn.prepareStatement(sql);
            psta.setInt(1,newValue);
            psta.setInt(2,teaId);

            res = psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }

        return res > 0;
    }

}