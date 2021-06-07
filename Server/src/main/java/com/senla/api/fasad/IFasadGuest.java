package com.senla.api.fasad;



import com.senla.api.enums.GuestGender;
import com.senla.model.Guest;

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

    void deleteGuest(Integer id);

    void setGuestList(List list);

    void updateGuest(Guest guest);

    void saveGuest(Guest guest);
}
