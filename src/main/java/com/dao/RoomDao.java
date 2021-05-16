package com.dao;

import com.api.dao.IRoomDao;
import com.hibernate.HibernateSessionFactoryUtil;
import com.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDao implements IRoomDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ArrayList<Room> roomList = new ArrayList<>();

    private RoomDao() {
    }


    @Override
    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public List<Room> getRoomList() {
        List<Room> rooms = (List<Room>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Room").list();
        return rooms;
    }

    @Override
    public void delete(Room room) {
        entityManager.remove(room);

    }

    @Override
    public void save(Room room) {
        entityManager.persist(room);
    }


    @Override
    public Room findById(Integer id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public void update(Room room) {
        entityManager.merge(room);
    }
}
/**
 * for jdbc
 * down
 */
//
//    @Override
//    public void setRoomList(ArrayList<Room> roomList) {
//        this.roomList = roomList;
//    }
//
//    @Override
//    public ArrayList<Room> getRoomList() {
//        String sql = "select * from " + Constants.ROOM_TABLE;
//        try {
//            ArrayList<Room> rooms = new ArrayList<>();
//            RoomStatus roomStatus = null;
//            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);
//            while (rs.next()) {
//                Integer id = (rs.getInt("roomNumber"));
//                if (rs.getString("roomStatus").equals("FREE")) {
//                    roomStatus = RoomStatus.FREE;
//                }
//                if (rs.getString("roomStatus").equals("REPAIRS")) {
//                    roomStatus = RoomStatus.REPAIRS;
//                }
//                if (rs.getString("roomStatus").equals("BUSY")) {
//                    roomStatus = RoomStatus.BUSY;
//                }
//                Integer capacity = (rs.getInt("capacity"));
//                Integer stars = (rs.getInt("stars"));
//                Integer price = (rs.getInt("price"));
//                Room room = new Room(id, roomStatus, capacity, price, stars);
//                rooms.add(room);
//                IdGenerator.setRoomID(id + 1);
//            }
//            setRoomList(rooms);
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return new ArrayList<>(roomList);
//    }
//
//
//    @Override
//    public void delete(Integer id) {
//        String sql = "delete from " + Constants.ROOM_TABLE + " where roomNumber=? ";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }
//
//    @Override
//    public void save(Room room) {
//        String insert = "insert into "
//                + Constants.ROOM_TABLE
//                + "(" + Constants.ROOM_NUMBER
//                + ","
//                + Constants.ROOM_STATUS
//                + ","
//                + Constants.ROOM_CAPACITY
//                + ","
//                + Constants.ROOM_STARS
//                + ","
//                + Constants.ROOM_PRICE
//                + ")" + "values(?,?,?,?,?)";
//        try {
//            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
//            preparedStatement.setInt(1, room.getRoomNumber());
//            preparedStatement.setString(2, String.valueOf(room.getRoomStatus()));
//            preparedStatement.setInt(3, room.getCapacity());
//            preparedStatement.setInt(4, room.getStars());
//            preparedStatement.setInt(5, room.getPrice());
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }
//
//    @Override
//    public Room findById(Integer id) {
//        Room room = new Room();
//        String sql = "Select * from " + Constants.ROOM_TABLE + " where roomNumber=?";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                RoomStatus roomStatus = null;
//                Integer roomNumber = (rs.getInt("roomNumber"));
//                if (rs.getString("roomStatus").equals("FREE")) {
//                    roomStatus = RoomStatus.FREE;
//                }
//                if (rs.getString("roomStatus").equals("REPAIRS")) {
//                    roomStatus = RoomStatus.REPAIRS;
//                }
//                if (rs.getString("roomStatus").equals("BUSY")) {
//                    roomStatus = RoomStatus.BUSY;
//                }
//                Integer capacity = (rs.getInt("capacity"));
//                Integer stars = (rs.getInt("stars"));
//                Integer price = (rs.getInt("price"));
//                room = new Room(roomNumber, roomStatus, capacity, price, stars);
//            }
//            rs.close();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return room;
//    }
//
//    @Override
//    public void update(Room room) {
//
//        String sql = "UPDATE " + Constants.ROOM_TABLE + " set roomStatus=?,capacity=?,stars=?,price=?  where roomNumber=?;";
//        PreparedStatement preparedStatement = null;
//
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(5, room.getRoomNumber());
//            preparedStatement.setString(1, String.valueOf(room.getRoomStatus()));
//            preparedStatement.setInt(2, room.getCapacity());
//            preparedStatement.setInt(3, room.getStars());
//            preparedStatement.setInt(4, room.getPrice());
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//
//        } catch (SQLException e) {
//
//            System.err.println(e);
//        }
//
//    }
//}



