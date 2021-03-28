package com.api.service;

import com.api.enums.GuestGender;
import com.model.Guest;

import java.util.List;

public interface IGuestService {
    Guest findById(Integer id);

    List showAllGuests();



    Guest createGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address);

    void changeGuestName(Integer idGuest, String name);

    void changeGuestAge(Integer idGuest, Integer age);

    List sortedByAge();

    List sortedById();

    List sortedByName();

    void deleteGuest(Integer id);

    void setGuestLIst(List list);

}
