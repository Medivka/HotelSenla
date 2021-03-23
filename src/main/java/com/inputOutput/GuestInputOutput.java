package com.inputOutput;

import com.dao.GuestDao;
import com.fasad.FasadGuest;
import com.model.Guest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuestInputOutput {

    private static GuestInputOutput instance;
    private String guestPathInFile = "src/main/java/com/hdd/guests.dat";

    public static GuestInputOutput getInstance() {
        if (instance == null) {
            instance = new GuestInputOutput();
        }
        return instance;
    }

       public void writeInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(guestPathInFile))) {
            oos.writeObject(GuestDao.getInstance().getGuestList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(guestPathInFile))) {
           GuestDao.getInstance().setGuestList((ArrayList<Guest>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
