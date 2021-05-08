package com.fasad;

import com.api.enums.RoomStatus;
import com.api.fasad.IFasadRoom;
import com.api.service.IRoomService;
import com.model.Room;
import com.service.RoomService;

import java.util.List;

public class FasadRoom implements IFasadRoom {
    private static IRoomService roomService = RoomService.getInstance();
    private static FasadRoom instance;

    public static FasadRoom getInstance() {
        if (instance == null) {
            instance = new FasadRoom();
        }
        return instance;
    }

    @Override
    public void deleteRoom(Room room) {
        roomService.deleteRoom(room);
    }

    @Override
    public List<Room> showAllRoom() {
        return roomService.showAllRoom();
    }

    @Override
    public Room findById(Integer IdRoom) {
        return roomService.findById(IdRoom);
    }

    @Override
    public Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars) {
        return roomService.createRoom(roomStatus, copacity, price, stars);
    }

    @Override
    public void changeRoomStars(Integer IdRoom, Integer stars) {
        roomService.changeRoomStars(IdRoom, stars);
    }

    @Override
    public void changeRoomStatus(Integer idroom, RoomStatus roomStatus) {
        roomService.changeStatusRoom(idroom, roomStatus);
    }

    @Override
    public void changeRoomCopacity(Integer idroom, Integer copacity) {
        roomService.changeRoomCapacity(idroom, copacity);
    }

    @Override
    public void changeRoomPrice(Integer idroom, Integer price) {
        roomService.changeRoomPrice(idroom, price);
    }

    @Override
    public List<Room> sortedByStars() {
        return roomService.sortedByStars();
    }

    @Override
    public List<Room> sortedByCopacity() {
        return roomService.sortedByCapacity();
    }

    @Override
    public List<Room> sortedByPrice() {
        return roomService.sortedByPrice();
    }

    @Override
    public List<Room> allFreeRoom() {
        return roomService.allFreeRoom();
    }

    @Override
    public void setRoomList(List list) {
        roomService.setRoomList(list);
    }

    @Override
    public void updateRoom(Room room) {
        roomService.updateRoom(room);
    }

}
