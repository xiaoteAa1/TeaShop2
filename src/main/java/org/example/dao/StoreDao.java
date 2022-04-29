package org.example.dao;

/*
    操作store库存表
 */
public interface StoreDao {
    //SELECT
    int getTeaStoreById(int teaId);

    //INSERT
    boolean addTeaStore(int teaId,int store);

    //UPDATE
    boolean updateTeaStore(int teaId,int newValue);

}
