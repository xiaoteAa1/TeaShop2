package org.example.dao;

public interface StatisticDao {
    //SELECT
    int getSale(int teaId);

    //INSERT
    boolean add(int teaId,int sale);

    //UPDATE
    boolean updateSale(int teaId,int incr);

}