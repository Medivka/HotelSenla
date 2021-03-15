package api.service;

import model.Order;
import api.enums.RoomStatus;
import model.Room;

import java.util.List;

public interface IRoomService {


    void setRoomList(List list);

    void writeInFile();

    void readFromFile();

    Room findById(Integer id);

   List showAllRoom();

    Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars);

    void changeRoomStars(Integer idRoom, Integer stars);

    void changeStatusRoom(Integer idRoom, RoomStatus roomStatus);

    void changeRoomCapacity(Integer idRoom, Integer capacity);

    void changeRoomPrice(Integer idRoom, Integer price);

    List sortedByPrice();

    List sortedByStars();

    List sortedByCapacity();

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
