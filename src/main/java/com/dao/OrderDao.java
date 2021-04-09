package com.dao;

import com.api.dao.IOrderDao;
import com.exceptions.DaoException;
import com.fasad.FasadOrder;
import com.model.Order;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class OrderDao implements IOrderDao {
    Order order;

    private static OrderDao instance;

    private List<Order> orderList = new ArrayList<>();

    private OrderDao() {
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }


    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
    public List<Order> getOrderList() {

        return new ArrayList<>(orderList);
    }


    @Override
    public void save(Order order) {
        orderList.add(order);
    }

    @Override
    public void delete(Integer id) {
        try {
            if (id < orderList.size() + 1) {
                for (int i = 0; i < orderList.size(); i++) {
                    Order order = orderList.get(i);
                    if (id.equals(order.getId())) {
                        orderList.remove(i);
                    }
                }
            }
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public Order findById(Integer id) {
        try {
            for (int i = 0; i < orderList.size(); i++) {
                Order order = orderList.get(i);
                if (id.equals(order.getId())) {
                    return order;
                }
            }
            return order;
        } catch (DaoException e) {
            throw e;
        }
    }

}




