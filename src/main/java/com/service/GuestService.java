package com.service;


import com.api.enums.GuestGender;
import com.api.service.IGuestService;
import com.dao.GuestDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceExeption;

import com.model.Guest;

import com.util.IdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GuestService implements IGuestService {

    private GuestDao guestDao;
    private static final Logger LOGGER = Logger.getLogger(GuestService.class.getName());
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
        try {
            LOGGER.log(Level.INFO, String.format("Find by Id %s", id));
            Guest guest = guestDao.findById(id);
            return guest;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "findById %s", id);
            throw new ServiceExeption("findByID failed", e);
        }

    }

    @Override
    public List<Guest> showAllGuests() {
        LOGGER.log(Level.INFO, String.format("showAllGuest"));
        return new ArrayList<>(guestDao.getGuestList());
    }

    @Override
    public Guest createGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address) {
        Guest guest = new Guest(IdGenerator.generateGuestId(), name,lastName, age,phone,guestGender,email,address);
        LOGGER.log(Level.INFO, String.format("createNewGuest id: %s,name: %s, lastName: %s, age: %s, phone: %s, guestGender: %s, email: %s, address: %s. ", guest.getGuestNumber(), name,lastName, age,phone,guestGender,email,address));
        guestDao.save(guest);
        return guest;
    }

    @Override
    public void changeGuestName(Integer idGuest, String name) {
        try {
            Guest guest = guestDao.findById(idGuest);
            LOGGER.log(Level.INFO, String.format("changeGuestName  id: %s,name: %s.", guest.getGuestNumber(), name));
            if (guest == null) {
            } else
                guest.setName(name);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeGuestName failed");
            throw new ServiceExeption("changeGuestName failed");
        }
    }

    @Override
    public void changeGuestAge(Integer idGuest, Integer age) {
        try {
            LOGGER.log(Level.INFO, String.format("changeGuestAge  id: %s,new age: %s.", idGuest, age));
            Guest guest = guestDao.findById(idGuest);
            guest.setAge(age);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeGuestAge failed");
            throw new ServiceExeption("changeGuestAge failed", e);
        }
    }

    @Override
    public List sortedByAge() {
        LOGGER.log(Level.INFO, String.format("sortedByAge"));
       List<Guest> guests = new ArrayList<>(guestDao.getGuestList());
        guests.stream().sorted(((o1, o2) -> o1.getAge() - o2.getAge())).collect(Collectors.toList());
        return guests;
    }

    @Override
    public List sortedById() {
        LOGGER.log(Level.INFO, String.format("sortedById"));
       List<Guest> guests = new ArrayList<>(guestDao.getGuestList());
        guests.stream().sorted(((o1, o2) -> o1.getGuestNumber() - o2.getGuestNumber())).collect(Collectors.toList());
        return guests;
    }

    @Override
    public List sortedByName() {
        LOGGER.log(Level.INFO, String.format("sortedByName"));
       List<Guest> guests = guestDao.getGuestList();
        guests.stream().sorted(Comparator.comparing(Guest::getName)).collect(Collectors.toList());
        return guests;
    }

    @Override
    public void deleteGuest(Integer id){
        LOGGER.log(Level.INFO, String.format("delete guest %s",id));
        guestDao.delete(id);
    }
    @Override
    public void setGuestLIst(List list) {
        LOGGER.log(Level.INFO, String.format("setGuestList"));
        guestDao.setGuestList(list);
    }


}
