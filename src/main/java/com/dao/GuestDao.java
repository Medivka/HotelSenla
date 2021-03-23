package com.dao;

import com.api.dao.IGuestDao;
import com.exceptions.DaoException;
import com.fasad.FasadGuest;
import com.model.Guest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuestDao implements IGuestDao {

    Guest guest;
    private static GuestDao instance;
    private String guestPathInFile = "src/main/java/com/hdd/guests.dat";

    private GuestDao() {
    }

    public static GuestDao getInstance() {
        if (instance == null) {
            instance = new GuestDao();
        }
        return instance;
    }

    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }
    private ArrayList<Guest> guestList = new ArrayList<>();
    public ArrayList<Guest> getGuestList() {
        return new ArrayList<>(guestList);
    }


    @Override
    public void delete(Integer id) {
        try {
            if (id < guestList.size() + 1) {
                for (int i = 0; i < guestList.size(); i++) {
                    Guest guest = guestList.get(i);
                    if (id.equals(guest.getGuestNumber())) {
                        guestList.remove(i);
                    }
                }
            }
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public void save(Guest guest) {
        guestList.add(guest);
    }


    @Override
    public Guest findById(Integer id) {
        try {
            for (int i = 0; i < guestList.size(); i++) {
                guest = guestList.get(i);
                if (id.equals(guest.getGuestNumber())) {
                    return guest;
                }
            }
            return guest = null;
        } catch (DaoException e) {
            throw e;
        }
    }


    @Override
    public Guest update(Integer id, String name, Integer age) {
        try {
            for (int i = 0; i < guestList.size(); i++) {
                Guest guest = guestList.get(i);

                if (id.equals(guest.getGuestNumber())) {
                    guest.setName(name);
                    guest.setAge(age);
                    return guest;
                } else guest = null;
            }
            return guest;
        } catch (DaoException e) {
            throw e;
        }
    }
}
