package dao;

import api.dao.IOrderDao;
import exceptions.DaoException;
import model.Guest;
import model.Order;
import model.Room;
import model.Service;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderDao implements IOrderDao {
    private static OrderDao instance;
    Order order;
    private OrderDao() {
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }


    private List<Order> orderList = new ArrayList<>();


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
     }catch (DaoException e) {
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




