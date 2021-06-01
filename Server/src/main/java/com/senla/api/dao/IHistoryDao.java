package com.senla.api.dao;



import com.senla.model.Order;

import java.util.ArrayList;

public interface IHistoryDao {
    ArrayList<Order> getHistoryList();

    void setHistoryList(ArrayList<Order> historyList);

    void save(Order order);

    Order findById(Integer id);

    void delete(Integer id);
}
