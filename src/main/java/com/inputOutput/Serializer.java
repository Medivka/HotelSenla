package com.inputOutput;

import com.dao.GuestDao;
import com.dao.OrderDao;
import com.dao.RoomDao;
import com.dao.ServiceDao;
import com.fasad.FasadGuest;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
    private static Serializer instance;

    public static Serializer getInstance() {
        if (instance == null) {
            instance = new Serializer();
        }
        return instance;
    }

    public void write(String path, List list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(list);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List read(String path, Class clazz) {
        List<?> lists = null;
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            lists = (List<Class>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FasadGuest.getInstance().setGuestList(lists);
        return lists;

    }

}