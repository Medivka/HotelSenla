package api.service;

import model.Order;
import api.enums.RoomStatus;
import model.Room;

import java.util.List;

public interface IRoomService {


    Room findById(Integer id);

   List showAllRoom();

    Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars);

    void changeRoomStars(Integer idRoom, Integer stars);

    void changeStatusRoom(Integer idRoom, RoomStatus roomStatus);

    void changeRoomCopacity(Integer idRoom, Integer copacity);

    void changeRoomPrice(Integer idRoom, Integer price);

    List sortedByPrice();

    List sortedByStars();

    List sortedByCopacity();

    List<Room> allFreeRoom();
//
//
//
//
//
//
//    Order changeStatusRoom(Order order, RoomStatus roomStatus);
//
//    Order changeRoomCopacity(Order order, Integer copacity);
//
//    Order changeRoomPrice(Order order, Integer price);
//
//
//    void sortedRoomByPrice();
}
