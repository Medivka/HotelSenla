package com.senla.api.service;



import com.senla.api.enums.GuestGender;
import com.senla.model.Guest;

import java.util.List;

public interface IGuestService {
    Guest findById(Integer id);

    List showAllGuests();



    Guest createGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address);

    void updateGuest(Guest guest);

    void changeGuestName(Integer idGuest, String name);

    void changeGuestAge(Integer idGuest, Integer age);

    List sortedByAge();

    List sortedById();

    List sortedByName();

    void deleteGuest(Guest guest);

    void setGuestLIst(List list);

    void saveGuest(Guest guest);
}
