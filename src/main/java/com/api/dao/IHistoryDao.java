package com.api.dao;

import com.model.History;
import com.model.Order;

import java.util.ArrayList;

public interface IHistoryDao {
    ArrayList<Order> getHistoryList();

    void setHistoryList(ArrayList<Order> historyList);

    void save(Order order);

    Order findById(Integer id);

    void delete(Integer id);
}
