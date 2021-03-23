package com.inputOutput;

import com.dao.GuestDao;
import com.dao.OrderDao;
import com.dao.RoomDao;
import com.dao.ServiceDao;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;


import java.io.*;
import java.util.ArrayList;

public class Serializer {
    private static Serializer instance;

    public static Serializer getInstance() {
        if (instance == null) {
            instance = new Serializer();
        }
        return instance;
    }

    private String guestPathInFile = "src/main/java/com/hdd/guests.dat";
    private String orderPathInFile = "src/main/java/com/hdd/orders.dat";
    private String roomPathInFile = "src/main/java/com/hdd/rooms.dat";
    private String servicePathInFile = "src/main/java/com/hdd/services.dat";

    public void writeInFile(String model) {
        if(model.equals("guests")){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(guestPathInFile))) {
                oos.writeObject(GuestDao.getInstance().getGuestList());
             } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }}
        if(model.equals("orders")){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(orderPathInFile))) {
                oos.writeObject(OrderDao.getInstance().getOrderList());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }if(model.equals("rooms")){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(roomPathInFile))) {
                oos.writeObject(RoomDao.getInstance().getRoomList());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }if(model.equals("services")){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(servicePathInFile))) {
                oos.writeObject(ServiceDao.getInstance().getServiceList());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void readFromFile(String model) {
        if (model.equals("orders")){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orderPathInFile))) {
                OrderDao.getInstance().setOrderList((ArrayList<Order>) ois.readObject());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }}
        if(model.equals("rooms")){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(roomPathInFile))) {
                RoomDao.getInstance().setRoomList((ArrayList<Room>) ois.readObject());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(model.equals("guests")){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(guestPathInFile))) {
                GuestDao.getInstance().setGuestList((ArrayList<Guest>) ois.readObject());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (model.equals("services")){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(servicePathInFile))) {
                ServiceDao.getInstance().setServiceList((ArrayList<Service>) ois.readObject());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}