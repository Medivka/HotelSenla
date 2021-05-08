package com.api.fasad;

import com.api.enums.GuestGender;
import com.model.Guest;

import java.util.List;

public interface IFasadGuest {
    Guest findById(Integer guestNumber);

    void changeName(Integer idGuest, String Name);

    List<Guest> showAllGuests();

    Guest createNewGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address);

    void changeGuestAge(Integer idGuest, Integer Age);

    List<Guest> sortedByAge();

    List<Guest> sortedById();

    List<Guest> sortedByName();

    void deleteGuest(Guest guest);

    void setGuestList(List list);

    void updateGuest(Guest guest);
}
