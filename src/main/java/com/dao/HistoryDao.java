package com.dao;

import com.api.dao.IHistoryDao;
import com.exceptions.DaoException;
import com.model.History;
import com.model.Order;

import java.util.ArrayList;

public class HistoryDao implements IHistoryDao {
   Order order;
    private static HistoryDao instance;



    private ArrayList<Order> historyList = new ArrayList<>();

    private HistoryDao() {
    }


    public static HistoryDao getInstance() {
        if (instance == null) {
            instance = new HistoryDao();
        }
        return instance;
    }

    public ArrayList<Order> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<Order> historyList) {
        this.historyList = historyList;
    }


    @Override
    public void save(Order  order) {
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
