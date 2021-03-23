package com.api.service;

import com.model.Guest;

import java.util.List;

public interface IGuestService {
    Guest findById(Integer id);

    List showAllGuests();

    Guest createGuest(String name, Integer age);

    void changeGuestName(Integer idGuest, String name);

    void changeGuestAge(Integer idGuest, Integer age);

    List sortedByAge();

    List sortedById();

    List sortedByName();

    void deleteGuest(Integer id);

    void setGuestLIst(List list);

}
