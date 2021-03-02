package dao;

import api.dao.IGuestDao;
import exceptions.DaoException;
import model.Guest;
import model.Room;
import model.Service;
import service.RoomService;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuestDao implements IGuestDao {


    private static GuestDao instance;

    private GuestDao() {
    }

    public static GuestDao getInstance() {
        if (instance == null) {
            instance = new GuestDao();
        }
        return instance;
    }

    Guest guest;
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
            } else
                System.out.println("guest not found");
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
                Guest guest = guestList.get(i);
                if (id.equals(guest.getGuestNumber())) {
                    return guest;
                }
            }
            return guest;
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
