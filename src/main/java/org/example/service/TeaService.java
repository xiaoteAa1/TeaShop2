package org.example.service;

import org.example.domain.Tea;

import java.util.List;

public interface TeaService {

    Tea getTeaById(int teaId);
    Tea getTeaByName(String name);

    List<Tea> getAllTea();
    List<Tea> getTeasByType(String type);
    List<Tea> getAllTeaOnSale();

    //====UPDATE====
    //更新tea表和store表的数据
    boolean updateAll(int id,String name,double price,String type,int isSale,String remark,int count);

    //====INSERT====
    boolean addTea(Tea tea);


    //====DELETE====
    boolean deleteTea(int id);
}
