package dao;

import api.dao.IGuestDao;
import model.Guest;
import model.Room;
import model.Service;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class GuestDao implements IGuestDao {

    Guest guest;
    private ArrayList<Guest> guestList = new ArrayList<>();

    public ArrayList<Guest> getGuestList() {
        return new ArrayList<>(guestList);
    }


    @Override
    public void delete(Integer id) {
        if (id < guestList.size() + 1) {
            for (int i = 0; i < guestList.size(); i++) {
                Guest guest = guestList.get(i);
                if (id.equals(guest.getGuestNumber())) {
                    guestList.remove(i);
                }
            }
        } else System.out.println("guest not found");
    }

    @Override
    public void save(Guest guest) {
        guestList.add(guest);
    }


    @Override
    public Guest findById(Integer id) {
        for (int i = 0; i < guestList.size(); i++) {
            Guest guest = guestList.get(i);
            if (id.equals(guest.getGuestNumber())) {
                return guest;
            } else guest = null;
        }
        return guest;
    }

    @Override
    public Guest update(Integer id, String name, Integer age) {
        for (int i = 0; i < guestList.size(); i++) {
            Guest guest = guestList.get(i);

            if (id.equals(guest.getGuestNumber())) {
                guest.setName(name);
                guest.setAge(age);
                return guest;
            } else guest = null;
        }
        return guest;
    }
}
