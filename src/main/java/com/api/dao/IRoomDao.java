package com.api.dao;

import com.model.Room;

public interface IRoomDao {

    void delete(Integer id);
    void     save(Room room);
    Room findById(Integer id);


}
