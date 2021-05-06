package com.api.dao;

import com.model.Guest;

import java.util.List;

public interface IGuestDao {

    void setGuestList(List<Guest> guestList);
    List<Guest> getGuestList();
    void delete(Guest guest);
    void save(Guest guest);
    Guest findById(Integer id);
    void  update(Guest guest);
}
