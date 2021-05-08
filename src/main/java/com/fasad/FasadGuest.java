package com.fasad;


import com.api.dao.IGuestDao;
import com.api.enums.GuestGender;

import com.api.fasad.IFasadGuest;
import com.model.Guest;
import com.model.Room;
import com.model.Service;
import com.service.GuestService;

import java.time.LocalDate;
import java.util.List;

public class FasadGuest implements IFasadGuest {
    private static GuestService guestService = GuestService.getInstance();
    private static FasadGuest instance;

    public static FasadGuest getInstance() {
        if (instance == null) {
            instance = new FasadGuest();
        }
        return instance;
    }
@Override
    public Guest findById(Integer guestNumber) {
        Guest guest = guestService.findById(guestNumber);
        return guest;
    }
@Override
    public void changeName(Integer idGuest, String Name) {
        guestService.changeGuestName(idGuest, Name);
    }
@Override
    public List<Guest> showAllGuests() {
        return guestService.showAllGuests();
    }
@Override
    public Guest createNewGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address) {
        return guestService.createGuest(name, lastName, age, phone, guestGender, email, address);
    }
@Override
    public void changeGuestAge(Integer idGuest, Integer Age) {
        guestService.changeGuestAge(idGuest, Age);
    }
@Override
    public List<Guest> sortedByAge() {
        return guestService.sortedByAge();
    }
@Override
    public List<Guest> sortedById() {
        return guestService.sortedById();
    }
@Override
    public List<Guest> sortedByName() {
        return guestService.sortedByName();
    }
@Override
    public void deleteGuest(Guest guest) {
        guestService.deleteGuest(guest);
    }
@Override
    public void setGuestList(List list) {
        guestService.setGuestLIst(list);
    }
@Override
    public void updateGuest(Guest guest) {
        guestService.updateGuest(guest);
    }


}
