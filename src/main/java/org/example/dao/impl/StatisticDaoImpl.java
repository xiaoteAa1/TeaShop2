package org.example.dao.impl;

import org.example.dao.StatisticDao;
import org.example.utils.JDBCUtils;

import java.sql.*;

public class StatisticDaoImpl implements StatisticDao {
    Connection conn;
    PreparedStatement psta;
    Statement sta;
    ResultSet rs;

    @Override
    public int getSale(int teaId) {
        int sale = 0;

        try {
            String sql = "SELECT count FROM statistic WHERE teaId=?";
            conn = JDBCUtils.getConnection();

            psta = conn.prepareStatement(sql);
            psta.setInt(1,teaId);

            rs = psta.executeQuery();
            if(!rs.next()){//判断teaId是否存在
                return 0;
            }
            sale = rs.getInt("sale");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }

        return sale;
    }

    @Override
    public boolean add(int teaId, int sale) {
        int res = 0;
        try {
            String sql = "INSERT INTO statistic(teaId,sale) VALUES(?,?)";
            conn = JDBCUtils.getConnection();

            psta = conn.prepareStatement(sql);
            psta.setInt(1,teaId);
            psta.setInt(2,sale);

            res = psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }

        return res > 0;
    }

    /**
     * 销量一般都是增加！
     * @param teaId
     * @param incr
     * @return
     */
    @Override
    public boolean updateSale(int teaId, int incr) {
        int res = 0;
        try {
            String sql = "UPDATE statistic SET sale=sale+? WHERE teaId=?";
            conn = JDBCUtils.getConnection();

            psta = conn.prepareStatement(sql);
            psta.setInt(1,incr);
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
