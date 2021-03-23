package com.dao;

import com.api.dao.IHistoryDao;
import com.exceptions.DaoException;
import com.model.History;
import com.model.Order;

import java.util.ArrayList;

public class HistoryDao implements IHistoryDao {
    History history;
    private static HistoryDao instance;
    private ArrayList<History> historyList = new ArrayList<>();

    private HistoryDao() {
    }


    public static HistoryDao getInstance() {
        if (instance == null) {
            instance = new HistoryDao();
        }
        return instance;
    }

    public ArrayList<History> getHistoryList() {
        return new ArrayList<>(historyList);
    }


    @Override
    public void save(History history) {
        historyList.add(history);
    }

    @Override
    public History findById(Integer id) {
        try {
            for (int i = 0; i < historyList.size(); i++) {
                History history = historyList.get(i);
                if (id.equals(history.getId())) {
                    return history;
                }
            }
            return history;
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            if (id < historyList.size() + 1) {
                for (int i = 0; i < historyList.size(); i++) {
                    History history = historyList.get(i);
                    if (id.equals(history.getId())) {
                        historyList.remove(i);
                    }
                }
            }
        } catch (DaoException e) {
            throw e;
        }
    }
}
