package com.fasad;

import com.inputOutput.GuestInputOutput;
import com.model.Guest;
import com.service.GuestService;

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

    public Guest createNewGuest(String name, Integer age) {
        return guestService.createGuest(name, age);
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

    public void deleteGuest(Integer id){
         guestService.deleteGuest(id);
    }

    public void setGuestList(List list) {
        guestService.setGuestLIst(list);
    }


}
