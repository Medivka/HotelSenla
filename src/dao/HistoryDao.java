package dao;

import api.dao.IHistoryDao;
import model.Order;
import util.IdGenerator;

import java.util.ArrayList;

public class HistoryDao implements IHistoryDao {
    Order order;
    private ArrayList<Order> historyList = new ArrayList<>();

    public ArrayList<Order> getHistoryList() {
        return new ArrayList<>(historyList);
    }


    @Override
    public void save(Order order) {
        historyList.add(order);
    }

    @Override
    public Order findById(Integer id) {
        for (int i = 0; i < historyList.size(); i++) {
            Order order = historyList.get(i);
            if (id.equals(order.getId())) {
                return order;
            } else order = null;
        }
        return order;
    }

    @Override
    public void delete(Integer id) {
        if (id < historyList.size() + 1) {
            for (int i = 0; i < historyList.size(); i++) {
                Order order = historyList.get(i);
                if (id.equals(order.getId())) {
                    historyList.remove(i);
                }
            }
        } else System.out.println("order not found");
    }
}
