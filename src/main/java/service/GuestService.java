package service;


import api.service.IGuestService;
import dao.GuestDao;
import exceptions.DaoException;
import exceptions.ServiceExeption;
import model.Guest;

import util.IdGenerator;

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
    public Guest createGuest(String name, Integer age) {
        Guest guest = new Guest(IdGenerator.generateGuestId(), name, age);
        LOGGER.log(Level.INFO, String.format("createNewGuest id: %s,name: %s, age: %s ", guest.getGuestNumber(), name, age));
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
        ArrayList<Guest> guests = new ArrayList<>(guestDao.getGuestList());
        guests.stream().sorted(((o1, o2) -> o1.getAge() - o2.getAge())).collect(Collectors.toList());
        return guests;
    }

    @Override
    public List sortedById() {
        LOGGER.log(Level.INFO, String.format("sortedById"));
        ArrayList<Guest> guests = new ArrayList<>(guestDao.getGuestList());
        guests.stream().sorted(((o1, o2) -> o1.getGuestNumber() - o2.getGuestNumber())).collect(Collectors.toList());
        return guests;
    }

    @Override
    public List sortedByName() {
        LOGGER.log(Level.INFO, String.format("sortedByName"));
        ArrayList<Guest> guests = guestDao.getGuestList();
        guests.stream().sorted(Comparator.comparing(Guest::getName)).collect(Collectors.toList());
        return guests;
    }
}