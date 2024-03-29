package com.senla.dao;

import com.senla.api.dao.IHistoryDao;
import com.senla.api.dao.IOrderDao;
import com.senla.exceptions.DaoException;
import com.senla.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class HistoryDao implements IHistoryDao {

    private Order order;

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
