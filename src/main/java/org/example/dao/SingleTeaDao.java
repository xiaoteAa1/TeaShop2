package org.example.dao;

import org.example.domain.SingleTea;

import java.util.List;

/**
 * 只操作Tea表，主要对Tea表进行增删改
 */
public interface SingleTeaDao {

    //SELECT
    //查询单条记录
    SingleTea getTeaByName(String name);


    //INSERT
    boolean addTea(SingleTea tea);

    //UPDATE
    //修改tea表信息
    boolean updateTea(int id,String name,double price,String type,int isSale,String remark);

    //DELETE
    boolean deleteTeaById(int id);

}