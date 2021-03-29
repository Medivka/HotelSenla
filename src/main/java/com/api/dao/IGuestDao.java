package com.api.dao;

import com.model.Guest;

public interface IGuestDao {

    void delete(Integer id);
    void save(Guest guest);
    Guest findById(Integer id);
    Guest update(Integer id, String name, Integer age);

}