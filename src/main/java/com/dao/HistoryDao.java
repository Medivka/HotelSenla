package com.dao;

import com.api.dao.IHistoryDao;
import com.api.dao.IOrderDao;
import com.exceptions.DaoException;

import com.model.History;
import com.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class HistoryDao implements IHistoryDao {

    Order order;

    @Autowired
    IOrderDao orderDao;

    private ArrayList<Order> historyList = new ArrayList<>();

    private HistoryDao() {
    }

    @Override
    public ArrayList<Order> getHistoryList() {
        setHistoryList((ArrayList<Order>) orderDao.getOrderList());
        return historyList;
    }

    @Override
    public void setHistoryList(ArrayList<Order> historyList) {
        this.historyList = historyList;
    }


    @Override
    public void save(Order order) {
        historyList.add(order);
    }

    @Override
    public Order findById(Integer id) {
        try {
            for (int i = 0; i < historyList.size(); i++) {
                Order order = historyList.get(i);
                if (id.equals(order.getId())) {
                    return order;
                }
            }
            return order;
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            if (id < historyList.size() + 1) {
                for (int i = 0; i < historyList.size(); i++) {
                    Order order = historyList.get(i);
                    if (id.equals(order.getId())) {
                        historyList.remove(i);
                    }
                }
            }
        } catch (DaoException e) {
            throw e;
        }
    }
}
