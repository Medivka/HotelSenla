package com.api.dao;

import com.model.History;
import com.model.Order;

public interface IHistoryDao {
    void save(Order order);

    Order findById(Integer id);

    void delete(Integer id);
}
