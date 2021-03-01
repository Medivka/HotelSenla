package service;

import api.dao.IRoomDao;
import api.service.IRoomService;
import dao.GuestDao;
import dao.RoomDao;
import model.Order;
import api.enums.RoomStatus;
import model.Room;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RoomService implements IRoomService {

    private static final Logger LOGGER=Logger.getLogger(RoomService.class.getName());
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
    public Room findById(Integer id) {
        LOGGER.log(Level.INFO,String.format("Find by Id %s", id));
        Room room = roomDao.findById(id);
        if(room==null){

        }
        return room;
    }

    @Override
    public List<Room> showAllRoom() {
        LOGGER.log(Level.INFO,String.format("showAllRoom"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
       return rooms;
    }

    @Override
    public Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars) {

        Room room = new Room(IdGenerator.generateRoomId(), roomStatus, copacity, price, stars);
        LOGGER.log(Level.INFO,String.format("createNewRoom id: %s,  roomstatus: %s, copacity: %s,  price: %s,  stars: %s. ",room.getRoomNumber() , roomStatus,copacity,price,stars));
        roomDao.save(room);
        return room;
    }

    @Override
    public void changeRoomStars(Integer idRoom, Integer stars) {
        Room room = roomDao.findById(idRoom);
        LOGGER.log(Level.INFO,String.format("changeRoomStars room id %s, new stars: %s   ", idRoom, stars));
        if(room==null){
            LOGGER.log(Level.WARNING,"Room not found");
        }else
        room.setStars(stars);

    }

    @Override
    public void changeStatusRoom(Integer idRoom, RoomStatus roomStatus) {
        Room room = roomDao.findById(idRoom);
        LOGGER.log(Level.INFO,String.format("changeRoomStatus room id %s, new roomstatus: %s   ", idRoom, roomStatus));
        if(room==null){

        }else
        room.setRoomStatus(roomStatus);
    }

    @Override
    public void changeRoomCapacity(Integer idRoom, Integer capacity) {
        Room room = roomDao.findById(idRoom);
        LOGGER.log(Level.INFO,String.format("changeRoomCapacity room id %s, new capacity: %s   ", idRoom, capacity));
        if(room==null){

        }else
        room.setCopacity(capacity);
    }

    @Override
    public void changeRoomPrice(Integer idRoom, Integer price) {
        Room room = roomDao.findById(idRoom);
        LOGGER.log(Level.INFO,String.format("changeRoomPrice room id %s, new price: %s   ", idRoom, price));
        if(room==null){

        }else
            room.setPrice(price);
    }

    @Override
    public List sortedByPrice() {
        LOGGER.log(Level.INFO,String.format("sortedByPrice"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList());
        return rooms;
    }

    @Override
    public List sortedByStars() {
        LOGGER.log(Level.INFO,String.format("sortedByStars"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getStars() - o2.getStars())).collect(Collectors.toList());
        return rooms;
    }

    @Override
    public List sortedByCapacity() {
        LOGGER.log(Level.INFO,String.format("sortedByCapacity"));
        ArrayList<Room> rooms = new ArrayList<>(roomDao.getRoomList());
        rooms.stream().sorted(((o1, o2) -> o1.getCopacity() - o2.getCopacity())).collect(Collectors.toList());
        return rooms;
    }

    @Override
    public List<Room> allFreeRoom() {
        LOGGER.log(Level.INFO,String.format("AllFreeRoom"));
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




