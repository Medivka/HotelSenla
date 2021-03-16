package dao;

import api.dao.IOrderDao;
import exceptions.DaoException;
import fasad.FasadOrder;
import fasad.FasadRoom;
import model.Guest;
import model.Order;
import model.Room;
import model.Service;
import util.IdGenerator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderDao implements IOrderDao {
    private static OrderDao instance;
    Order order;
    String orderPathInFile = "src/main/java/hdd/orders.dat";

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

    @Override
    public void writeInFile() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(orderPathInFile))) {
            oos.writeObject(orderList);

            oos.close();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void readFromFile() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orderPathInFile))) {

            FasadOrder.getInstance().setOrderList((ArrayList<Order>) ois.readObject());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}




