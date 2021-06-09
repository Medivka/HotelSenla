package com.senla.service;

import com.senla.api.dao.IRoomDao;
import com.senla.api.enums.RoomStatus;
import com.senla.api.service.IRoomService;
import com.senla.dao.RoomDao;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.exceptions.DaoException;
import com.senla.exceptions.ServiceExeption;
import com.senla.model.Room;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomService implements IRoomService {

    private static final Logger LOGGER = Logger.getLogger(RoomService.class.getName());
     @Autowired
     IRoomDao roomDao;


     @Autowired
    private RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void setRoomList(List list) {
        LOGGER.log(Level.INFO, String.format("setRoomList"));
        roomDao.setRoomList((ArrayList<Room>) list);
    }

    @Override
    public void updateRoom(Room room){

         roomDao.update(room);
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
            LOGGER.log(Level.WARN, "findById failed", e);
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
            LOGGER.log(Level.WARN, "showAllRoom",e);
            throw new ServiceExeption("showAllRoom", e);
        }
    }



    @Override
    public void deleteRoom(Integer id) {
        try {
            LOGGER.log(Level.INFO, String.format("room delete",id));
            roomDao.delete(roomDao.findById(id));
        }catch (DaoException e) {
            LOGGER.log(Level.WARN, "room delete",e);
            throw new ServiceExeption("room delete", e);
        }
    }

    @Override
    public Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars) {
        try {
            Room room = new Room( roomStatus, copacity, price, stars);
            LOGGER.log(Level.INFO, String.format("createNewRoom   roomstatus: %s, copacity: %s,  price: %s,  stars: %s. ",  roomStatus, copacity, price, stars));
            roomDao.save(room);
            return room;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "createRoom failed",e);
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
            LOGGER.log(Level.WARN, "changeRoomStars failed ", e);
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
            LOGGER.log(Level.WARN, "changeStatusRoom failed ", e);
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
            LOGGER.log(Level.WARN, "changeRoomPrice failed ",e);
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
        List<Room> freeRoom = new ArrayList<>();
       List<Room> rooms = roomDao.getRoomList();
        for (Room roo : rooms) {
            Room room = roo;
            if (roo.getRoomStatus().equals(RoomStatus.FREE)) {
                freeRoom.add(room);
            }
        }
        return freeRoom;
    }

    @Override
    public void save(Room room) {
        roomDao.save(room);
    }

    @Override
    public void updateRoom(Integer id, Room room) {
        Room room1=roomDao.findById(id);
        room1=room;
        roomDao.update(room1);
    }

}




