package service;


import api.service.IGuestService;
import dao.GuestDao;
import model.Guest;

import util.IdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService implements IGuestService {

    private GuestDao guestDao;

    private static GuestService instance;

    public static GuestService getInstance() {
        if (instance == null) {
            instance = new GuestService(GuestDao.getInstance());
        }
        return instance;
    }


    private GuestService(GuestDao guestDao) {
        this.guestDao = guestDao;
    }


    @Override
    public Guest findById(Integer id) {
        Guest guest = guestDao.findById(id);
        return guest;
    }

    @Override
    public List<Guest> showAllGuests() {
        return new ArrayList<>(guestDao.getGuestList());

    }

    @Override
    public Guest createGuest(String name, Integer age) {
        Guest guest = new Guest(IdGenerator.generateGuestId(), name, age);
        guestDao.save(guest);
        return guest;
    }

    @Override
    public void changeGuestName(Integer idGuest, String name) {
        Guest guest = guestDao.findById(idGuest);
        guest.setName(name);
    }

    @Override
    public void changeGuestAge(Integer idGuest, Integer age) {
        Guest guest = guestDao.findById(idGuest);
        guest.setAge(age);
    }

    @Override
    public List sortedByAge() {
        ArrayList<Guest> guests = new ArrayList<>(guestDao.getGuestList());
        guests.stream().sorted(((o1, o2) -> o1.getAge() - o2.getAge())).collect(Collectors.toList());
        return guests;
    }

    @Override
    public List sortedById() {
        ArrayList<Guest> guests = new ArrayList<>(guestDao.getGuestList());
        guests.stream().sorted(((o1, o2) -> o1.getGuestNumber() - o2.getGuestNumber())).collect(Collectors.toList());
        return guests;
    }

    @Override
    public List sortedByName() {
        ArrayList<Guest> guests = guestDao.getGuestList();
        guests.stream().sorted(Comparator.comparing(Guest::getName)).collect(Collectors.toList());
        return guests;
    }
}
