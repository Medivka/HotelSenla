package com.fasad;


import com.api.enums.GuestGender;

import com.model.Guest;
import com.model.Room;
import com.model.Service;
import com.service.GuestService;

import java.time.LocalDate;
import java.util.List;

public class FasadGuest {
    private static GuestService guestService = GuestService.getInstance();
    private static FasadGuest instance;

    public static FasadGuest getInstance() {
        if (instance == null) {
            instance = new FasadGuest();
        }
        return instance;
    }

    public Guest findById(Integer guestNumber) {
        Guest guest = guestService.findById(guestNumber);
        return guest;
    }

    public void changeName(Integer idGuest, String Name) {
        guestService.changeGuestName(idGuest, Name);
    }

    public List<Guest> showAllGuests() {
        return guestService.showAllGuests();
    }

    public Guest createNewGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address) {
        return guestService.createGuest(name,lastName,age,phone,guestGender,email,address);
    }

    public void changeGuestAge(Integer idGuest, Integer Age) {
        guestService.changeGuestAge(idGuest, Age);
    }

    public List<Guest> sortedByAge() {
        return guestService.sortedByAge();
    }

    public List<Guest> sortedById() {
        return guestService.sortedById();
    }

    public List<Guest> sortedByName() {
        return guestService.sortedByName();
    }

    public void deleteGuest(Guest guest){
         guestService.deleteGuest(guest);
    }

    public void setGuestList(List list) {
        guestService.setGuestLIst(list);
    }
public void updateGuest(Guest guest){guestService.updateGuest(guest);}


}
