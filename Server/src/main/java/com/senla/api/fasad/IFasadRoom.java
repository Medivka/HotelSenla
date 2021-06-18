package com.senla.api.fasad;

import com.senla.api.enums.RoomStatus;
import com.senla.model.Room;

import java.util.List;

public interface IFasadRoom {
    void save(Room room);

    void deleteRoom(Integer id);

    List<Room> showAllRoom();

    Room findById(Integer IdRoom);

    Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars);

    void changeRoomStars(Integer IdRoom, Integer stars);

    void changeRoomStatus(Integer idroom, RoomStatus roomStatus);

    void changeRoomCopacity(Integer idroom, Integer copacity);

    void changeRoomPrice(Integer idroom, Integer price);

    List<Room> sortedByStars();

    List<Room> sortedByCopacity();

    List<Room> sortedByPrice();

    List<Room> allFreeRoom();

    void setRoomList(List list);

    void updateRoom(Room room);

    void updateRoom(Integer id, Room room);
}
