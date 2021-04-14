package com.api.dao;

import com.model.*;

public interface IOrderDao {



    void     save(Order order);

    void delete(Integer id);

    Order findById(Integer id);


    void updateOrder(Order order);

    void addServiceInOrder(Order order, Service service);
}
