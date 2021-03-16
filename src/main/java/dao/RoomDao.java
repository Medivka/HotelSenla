package dao;

import api.dao.IRoomDao;
import exceptions.DaoException;
import fasad.FasadRoom;
import model.Room;
import api.enums.RoomStatus;
import model.Service;
import util.IdGenerator;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class RoomDao implements IRoomDao {
    Room room;


    String roomPathInFile = "src/main/java/hdd/rooms.dat";
    private ArrayList<Room> roomList = new ArrayList<>();

    private static RoomDao instance;

    private RoomDao() {
    }

    public static RoomDao getInstance() {
        if (instance == null) {
            instance = new RoomDao();
        }
        return instance;
    }

    public ArrayList<Room> getRoomList() {
        return new ArrayList<>(roomList);
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public void delete(Integer id) {
        try {
            if (id < roomList.size() + 1) {
                for (int i = 0; i < roomList.size(); i++) {
                    Room room = roomList.get(i);
                    if (id.equals(room.getRoomNumber())) {
                        roomList.remove(i);
                    }
                }
            } else System.out.println("room not found");
        } catch (DaoException e) {
            throw e;
        }

    }

    @Override
    public void save(Room room) {
        roomList.add(room);
    }


    @Override
    public Room findById(Integer id) {
        try {
            for (int i = 0; i < roomList.size(); i++) {
                Room room = roomList.get(i);
                if (id.equals(room.getRoomNumber())) {
                    return room;
                }
            }

            return room;
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public void writeInFile() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(roomPathInFile))) {
            oos.writeObject(roomList);

            oos.close();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void readFromFile() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(roomPathInFile))) {

            FasadRoom.getInstance().setRoomList((ArrayList<Room>) ois.readObject());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


}
