package com.inputOutput;

import com.dao.OrderDao;
import com.fasad.FasadOrder;
import com.model.Order;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OrderInputOutput {
private static OrderInputOutput instance;
    private String orderPathInFile = "src/main/java/com/hdd/orders.dat";

    public static OrderInputOutput getInstance() {
        if (instance == null) {
            instance = new OrderInputOutput();
        }
        return instance;
    }

    public void writeInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(orderPathInFile))) {
            oos.writeObject(OrderDao.getInstance().getOrderList());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void readFromFile() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orderPathInFile))) {

            OrderDao.getInstance().setOrderList((ArrayList<Order>) ois.readObject());

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
