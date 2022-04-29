package org.example.dao.impl;

import org.example.dao.TeaDao;
import org.example.domain.Tea;
import org.example.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 对tea store statistic表进行三表查询
 * 该类只进行 ”三表查询“ 操作！！！！
 */
@SuppressWarnings("all")
public class TeaDaoImpl implements TeaDao {
    Connection conn;
    PreparedStatement psta;
    Statement sta;
    ResultSet rs;


    //======================返回单条记录====================
    @Override
    public Tea getTeaById(int id) {
        try {
            String sql = "SELECT t.*,s.count,st.sale FROM tea t,store s,statistic st WHERE t.id=? AND s.teaId=? AND st.teaId=?";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setInt(1,id);
            psta.setInt(2,id);
            psta.setInt(3,id);

            rs = psta.executeQuery();

            Tea tea = new Tea();
            while (rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                tea = new Tea(id,name,price,type,isSale,remark,count,sale);
                tea.setCount(count);
            }
            return tea;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }
    }
    @Override
    public Tea getTeaByName(String name) {
        try {
            String sql = "SELECT t.*,s.count,st.sale FROM tea t,store s,statistic st WHERE t.name=? AND s.teaId=t.id AND st.teaId=t.id";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setString(1,name);

            rs = psta.executeQuery();

            Tea tea = new Tea();
            while (rs.next()){
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                tea = new Tea(id,name,price,type,isSale,remark,count,sale);
                tea.setCount(count);
            }
            return tea;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }
    }


    //======================返回返回多条记录====================
    @Override
    public List<Tea> getAllTea() {
        try {
            List<Tea> list = new ArrayList<>();

            String sql ="select t.*,IFNULL(s.count,0) count,IFNULL(sta.sale,0) sale from tea t left join \n" +
                    "store s on t.id=s.teaId left join statistic sta on t.id=sta.teaId";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                Tea tea = new Tea(id,name,price,type,isSale,remark,count,sale);
                list.add(tea);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs, sta,conn);
        }
    }
    @Override
    public List<Tea> getTeasByType(String type) {
        List<Tea> res = new ArrayList<>();
        List<Tea> list = getAllTea();
        for(Tea t:list){
            if(t.getType().equals(type)){
                res.add(t);
            }
        }
        return res;
    }
    @Override
    public List<Tea> getTeasByIsSale(int isSale) {
        List<Tea> res = new ArrayList<>();
        List<Tea> list = getAllTea();
        for(Tea t:list){
            if(t.getIsSale()==isSale){
                res.add(t);
            }
        }
        return res;
    }



}