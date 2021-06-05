package com.senla.fasad;

import com.senla.api.enums.RoomStatus;
import com.senla.api.fasad.IFasadRoom;
import com.senla.api.service.IRoomService;
import com.senla.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FasadRoom implements IFasadRoom {

    final
    IRoomService roomService;

    @Autowired
    public FasadRoom(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void save(Room room) {
        roomService.save(room);
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
