package dao;

import api.dao.IRoomDao;
import model.Room;
import api.enums.RoomStatus;
import model.Service;
import util.IdGenerator;


import java.util.ArrayList;


public class RoomDao implements IRoomDao {
    Room room;

    private ArrayList<Room> roomList = new ArrayList<>();

    public ArrayList<Room> getRoomList() {
        return new ArrayList<>(roomList);
    }



    @Override
    public void delete(Integer id) {
        if (id < roomList.size() + 1) {
            for (int i = 0; i < roomList.size(); i++) {
                Room room = roomList.get(i);
                if (id.equals(room.getRoomNumber())) {
                    roomList.remove(i);
                }
            }
        } else System.out.println("room not found");

    }

    @Override
    public void save(Room room) {
        roomList.add(room);
    }


    @Override
    public Room findById(Integer id) {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            if (id.equals(room.getRoomNumber())) {
                return room;
            } else room = null;
        }
        return room;
    }

    @Override
    public Room update(Integer id, RoomStatus roomStatus, Integer copacity, Integer price) {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);

            if (id.equals(room.getRoomNumber())) {
                room.setRoomStatus(roomStatus);
                room.setCopacity(copacity);
                room.setPrice(price);
                return room;
            } else room = null;
        }
        return room;

    }


}
