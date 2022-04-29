package org.example.service.impl;

import org.example.dao.SingleTeaDao;
import org.example.dao.StatisticDao;
import org.example.dao.StoreDao;
import org.example.dao.TeaDao;
import org.example.dao.impl.SingleTeaDaoImpl;
import org.example.dao.impl.StatisticDaoImpl;
import org.example.dao.impl.StoreDaoImpl;
import org.example.dao.impl.TeaDaoImpl;
import org.example.domain.SingleTea;
import org.example.domain.Tea;
import org.example.service.TeaService;
import org.example.utils.ConnectionHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeaServiceImpl implements TeaService {
    SingleTeaDao singleTeaDao = new SingleTeaDaoImpl();
    TeaDao teaDao = new TeaDaoImpl();
    StoreDao storeDao = new StoreDaoImpl();
    StatisticDao statisticDao = new StatisticDaoImpl();
    Connection conn;

    //=====SELECT=====
    @Override
    public Tea getTeaById(int teaId) {
        Tea tea = teaDao.getTeaById(teaId);

        return tea;
    }

    @Override
    public Tea getTeaByName(String name) {
        Tea tea = teaDao.getTeaByName(name);

        return tea;
    }


    /**
     * 1、查询tea、store、sta表的信息
     * @return
     */
    @Override
    public List<Tea> getAllTea() {
        List<Tea> teaList = teaDao.getAllTea();

        return teaList;
    }

    @Override
    public List<Tea> getTeasByType(String type) {
        List<Tea> teaList = teaDao.getTeasByType(type);

        return teaList;
    }
    /**
     * 1、查询tea表所有对象，限制条件：isSale=1
     * 2、查询store表和sta表数据
     * @return
     */
    @Override
    public List<Tea> getAllTeaOnSale() {
        List<Tea> list = teaDao.getTeasByIsSale(1);

        return list;
    }


    //=====UPDATE=====
    //这里需要事务！！！！！！！
    @Override
    public boolean updateAll(int id, String name, double price, String type, int isSale, String remark, int count) {
//        conn = ConnectionHandler.getConnection();
        //1、先更新tea表
        boolean r1 = singleTeaDao.updateTea(id,name,price,type,isSale,remark);

        //2、再更新store表库存
        boolean r2 = storeDao.updateTeaStore(id,count);

//        if(r1 && r2){
//            try {
//                conn.commit();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }else{
//            try {
//                conn.rollback();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        return r1 && r2;
    }



    //=====INSERT=====
    //这里需要事务！！！！！！！
    /**
     * 添加奶茶数据至tea、store、statistic表
     * @param tea
     * @return
     */
    @Override
    public boolean addTea(Tea tea) {

        //1、先添加到tea表
        boolean a = singleTeaDao.addTea(new SingleTea(tea.getName()
                ,tea.getPrice(),tea.getType(),tea.getIsSale(),tea.getRemark()));

        //2、再添加到store表
        int teaId = singleTeaDao.getTeaByName(tea.getName()).getTeaId();
        boolean b = storeDao.addTeaStore(teaId, tea.getCount());

        //3、再添加到sta表
        boolean c = statisticDao.add(teaId,tea.getSales());

        return a && b && c;
    }


    //=====DELETE=====
    @Override
    public boolean deleteTea(int id) {
        boolean b = singleTeaDao.deleteTeaById(id);
        return b;
    }

    public static void main(String[] args) {
        TeaServiceImpl test = new TeaServiceImpl();
        test.getAllTea();
    }
}
