package com.senla.api.dao;

import com.senla.model.Order;
import com.senla.model.Service;

import java.util.List;

public interface IOrderDao {


    void setOrderList(List<Order> orderList);

    List<Order> getOrderList();

    void     save(Order order);

    void delete(Order order);

    Order findById(Integer id);


    void updateOrder(Order order);

    void addServiceInOrder(Order order, Service service);
}
