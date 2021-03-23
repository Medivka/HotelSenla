package com.inputOutput;

import com.dao.RoomDao;
import com.fasad.FasadRoom;
import com.model.Room;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RoomInputOutput {

    private static RoomInputOutput instance;
    private String roomPathInFile = "src/main/java/com/hdd/rooms.dat";

    public static RoomInputOutput getInstance() {
        if (instance == null) {
            instance = new RoomInputOutput();
        }
        return instance;
    }

    public void writeInFile() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(roomPathInFile))) {
            oos.writeObject(RoomDao.getInstance().getRoomList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(roomPathInFile))) {
            RoomDao.getInstance().setRoomList((ArrayList<Room>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
