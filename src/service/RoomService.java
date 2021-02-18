package service;

import api.dao.IRoomDao;
import api.service.IRoomService;
import dao.RoomDao;
import model.Order;
import api.enums.RoomStatus;
import model.Room;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService implements IRoomService {

    private final RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


    @Override
    public Room findById(Integer id) {
        Room room = roomDao.findById(id);
        return room;
    }

    @Override
    public void showAllRoom() {
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        for (Room room : rooms
        ) {
            System.out.println(room);
        }
    }

    @Override
    public Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars) {
        Room room = new Room(IdGenerator.generateRoomId(), roomStatus, copacity, price, stars);
        roomDao.save(room);
        return room;
    }

    @Override
    public void changeRoomStars(Integer idRoom, Integer stars) {
        Room room = roomDao.findById(idRoom);
        room.setStars(stars);

    }

    @Override
    public void changeStatusRoom(Integer idRoom, RoomStatus roomStatus) {
        Room room = roomDao.findById(idRoom);
        room.setRoomStatus(roomStatus);
    }

    @Override
    public void changeRoomCopacity(Integer idRoom, Integer copacity) {
        Room room = roomDao.findById(idRoom);
        room.setCopacity(copacity);
    }

    @Override
    public void changeRoomPrice(Integer idRoom, Integer price) {
        roomDao.findById(idRoom).setPrice(price);
    }

    @Override
    public List sortedByPrice() {
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList()).forEach(room -> System.out.println(room));
        return rooms;
    }

    @Override
    public List sortedByStars() {
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getStars() - o2.getStars())).collect(Collectors.toList()).forEach(room -> System.out.println(room));
        return rooms;
    }

    @Override
    public List sortedByCopacity() {
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getCopacity() - o2.getCopacity())).collect(Collectors.toList()).forEach(room -> System.out.println(room));
        return rooms;
    }

    @Override
    public List<Room> allFreeRoom() {
        ArrayList<Room> freeRoom = new ArrayList<>();
        ArrayList<Room> rooms = roomDao.getRoomList();
        for (Room roo : rooms) {
            Room room = roo;
            if (roo.getRoomStatus().equals(RoomStatus.FREE)) {
                freeRoom.add(room);
            }
        }
        return freeRoom;
    }

}




