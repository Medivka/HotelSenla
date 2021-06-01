package com.senla.api.service;



import com.senla.api.enums.RoomStatus;
import com.senla.model.Room;

import java.util.List;

public interface IRoomService {


    void setRoomList(List list);

    void updateRoom(Room room);

    Room findById(Integer id);

   List showAllRoom();

    void deleteRoom(Room room);

    Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars);

    void changeRoomStars(Integer idRoom, Integer stars);

    void changeStatusRoom(Integer idRoom, RoomStatus roomStatus);

    void changeRoomCapacity(Integer idRoom, Integer capacity);

    void changeRoomPrice(Integer idRoom, Integer price);

    List sortedByPrice();

    List sortedByStars();

    List sortedByCapacity();

    List<Room> allFreeRoom();

}
