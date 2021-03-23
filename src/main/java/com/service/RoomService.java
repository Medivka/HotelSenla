package com.service;

import com.api.service.IRoomService;
import com.dao.RoomDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceExeption;
import com.api.enums.RoomStatus;
import com.model.Room;
import com.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RoomService implements IRoomService {

    private static final Logger LOGGER = Logger.getLogger(RoomService.class.getName());
    private final RoomDao roomDao;
    private static RoomService instance;

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService(RoomDao.getInstance());
        }
        return instance;
    }

    private RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void setRoomList(List list) {
        roomDao.setRoomList((ArrayList<Room>) list);
    }



    @Override
    public Room findById(Integer id) {
        try {
            Room room = roomDao.findById(id);
            LOGGER.log(Level.INFO, String.format("Find by Id %s", id));
            if (room == null) {
            }
            return room;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "findById failed %s", id);
            throw new ServiceExeption("findById failed", e);
        }
    }

    @Override
    public List<Room> showAllRoom() {
        try {
            LOGGER.log(Level.INFO, String.format("showAllRoom"));
            ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
            return rooms;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "showAllRoom");
            throw new ServiceExeption("showAllRoom", e);
        }
    }

    @Override
    public Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars) {
        try {
            Room room = new Room(IdGenerator.generateRoomId(), roomStatus, copacity, price, stars);
            LOGGER.log(Level.INFO, String.format("createNewRoom id: %s,  roomstatus: %s, copacity: %s,  price: %s,  stars: %s. ", room.getRoomNumber(), roomStatus, copacity, price, stars));
            roomDao.save(room);
            return room;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "createRoom failed");
            throw new ServiceExeption("createRoom failed", e);
        }
    }

    @Override
    public void changeRoomStars(Integer idRoom, Integer stars) {
        try {
            Room room = roomDao.findById(idRoom);
            LOGGER.log(Level.INFO, String.format("changeRoomStars room id %s, new stars: %s   ", idRoom, stars));
            if (room == null) {
                System.out.println("room not found");
            } else
                room.setStars(stars);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeRoomStars failed %s", idRoom);
            throw new ServiceExeption("changeRoomStars failed", e);
        }
    }

    @Override
    public void changeStatusRoom(Integer idRoom, RoomStatus roomStatus) {
        try {
            Room room = roomDao.findById(idRoom);
            LOGGER.log(Level.INFO, String.format("changeRoomStatus room id %s, new roomstatus: %s   ", idRoom, roomStatus));
            if (room == null) {
                System.out.println("room not found");
            } else
                room.setRoomStatus(roomStatus);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeStatusRoom failed %s", idRoom);
            throw new ServiceExeption("changeStatusRoom failed", e);
        }
    }

    @Override
    public void changeRoomCapacity(Integer idRoom, Integer capacity) {
        Room room = roomDao.findById(idRoom);
        LOGGER.log(Level.INFO, String.format("changeRoomCapacity room id %s, new capacity: %s   ", idRoom, capacity));
        if (room == null) {
            System.out.println("room not found");
        } else
            room.setCopacity(capacity);
    }

    @Override
    public void changeRoomPrice(Integer idRoom, Integer price) {
        try {
            Room room = roomDao.findById(idRoom);
            LOGGER.log(Level.INFO, String.format("changeRoomPrice room id %s, new price: %s   ", idRoom, price));
            if (room == null) {
                System.out.println("room not found");
            } else
                room.setPrice(price);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeRoomPrice failed %s", idRoom);
            throw new ServiceExeption("changeRoomPrice failed", e);
        }
    }

    @Override
    public List sortedByPrice() {
        LOGGER.log(Level.INFO, String.format("sortedByPrice"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList());
        return rooms;
    }

    @Override
    public List sortedByStars() {
        LOGGER.log(Level.INFO, String.format("sortedByStars"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getStars() - o2.getStars())).collect(Collectors.toList());
        return rooms;
    }

    @Override
    public List sortedByCapacity() {
        LOGGER.log(Level.INFO, String.format("sortedByCapacity"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getCapacity() - o2.getCapacity())).collect(Collectors.toList());
        return rooms;
    }

    @Override
    public List<Room> allFreeRoom() {
        LOGGER.log(Level.INFO, String.format("AllFreeRoom"));
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




