package com.senla.api.dao;

import com.senla.model.Room;
import java.util.ArrayList;
import java.util.List;

public interface IRoomDao {

    void setRoomList(ArrayList<Room> roomList);

    List<Room> getRoomList();

    void delete(Room room);

    void save(Room room);

    Room findById(Integer id);

    void update(Room room);
}
