package com.dao;

import com.api.dao.IRoomDao;
import com.api.enums.GuestGender;
import com.api.enums.RoomStatus;
import com.configsDB.Constants;
import com.databaseControllers.DatabaseHandler;
import com.exceptions.DaoException;
import com.fasad.FasadRoom;
import com.model.Guest;
import com.model.Room;
import com.model.Service;
import com.service.RoomService;
import com.util.IdGenerator;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RoomDao implements IRoomDao {
    Room room;


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

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    public ArrayList<Room> getRoomList() {
        String sql = "select * from " + Constants.ROOM_TABLE;
        try {
            ArrayList<Room> rooms = new ArrayList<>();
            RoomStatus roomStatus = null;
            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                Integer id = (rs.getInt("roomNumber"));
                if (rs.getString("roomStatus").equals("FREE")) {
                    roomStatus = RoomStatus.FREE;
                }
                if (rs.getString("roomStatus").equals("REPAIRS")) {
                    roomStatus = RoomStatus.REPAIRS;
                }
                if (rs.getString("roomStatus").equals("BUSY")) {
                    roomStatus = RoomStatus.BUSY;
                }
                Integer capacity = (rs.getInt("capacity"));
                Integer stars = (rs.getInt("stars"));
                Integer price = (rs.getInt("price"));
                Room room = new Room(id, roomStatus, capacity, price, stars);
                rooms.add(room);
                IdGenerator.setRoomID(id + 1);
            }
            setRoomList(rooms);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return new ArrayList<>(roomList);
    }


    @Override
    public void delete(Integer id) {
        String sql = "delete from " + Constants.ROOM_TABLE + " where roomNumber=? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void save(Room room) {
        String insert = "insert into "
                + Constants.ROOM_TABLE
                + "(" + Constants.ROOM_NUMBER
                + ","
                + Constants.ROOM_STATUS
                + ","
                + Constants.ROOM_CAPACITY
                + ","
                + Constants.ROOM_STARS
                + ","
                + Constants.ROOM_PRICE
                + ")" + "values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setString(2, String.valueOf(room.getRoomStatus()));
            preparedStatement.setInt(3, room.getCapacity());
            preparedStatement.setInt(4, room.getStars());
            preparedStatement.setInt(5, room.getPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public Room findById(Integer id) {
        Room room = new Room();
        String sql = "Select * from " + Constants.ROOM_TABLE + " where roomNumber=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RoomStatus roomStatus = null;
                Integer roomNumber = (rs.getInt("roomNumber"));
                if (rs.getString("roomStatus").equals("FREE")) {
                    roomStatus = RoomStatus.FREE;
                }
                if (rs.getString("roomStatus").equals("REPAIRS")) {
                    roomStatus = RoomStatus.REPAIRS;
                }
                if (rs.getString("roomStatus").equals("BUSY")) {
                    roomStatus = RoomStatus.BUSY;
                }
                Integer capacity = (rs.getInt("capacity"));
                Integer stars = (rs.getInt("stars"));
                Integer price = (rs.getInt("price"));
                room = new Room(roomNumber, roomStatus, capacity, price, stars);
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return room;
    }
    @Override
    public void update(Room room) {

        String sql = "UPDATE " + Constants.ROOM_TABLE + " set roomStatus=?,capacity=?,stars=?,price=?  where roomNumber=?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(5, room.getRoomNumber());
            preparedStatement.setString(1, String.valueOf(room.getRoomStatus()));
            preparedStatement.setInt(2, room.getCapacity());
            preparedStatement.setInt(3, room.getStars());
            preparedStatement.setInt(4, room.getPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {

            System.err.println(e);
        }

    }
}



