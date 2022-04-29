package org.example.dao;

import org.example.domain.Tea;

import java.util.List;

public interface TeaDao {
    //SELECT
    //查询单条记录
    Tea getTeaById(int id);
    Tea getTeaByName(String name);

    //查询多条记录
    List<Tea> getAllTea();
    List<Tea> getTeasByType(String type);
    List<Tea> getTeasByIsSale(int isSale);

}
