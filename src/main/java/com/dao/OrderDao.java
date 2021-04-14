package com.dao;

import com.api.dao.IOrderDao;
import com.api.enums.GuestGender;
import com.configsDB.Constants;
import com.databaseControllers.DatabaseHandler;
import com.exceptions.DaoException;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;
import com.util.IdGenerator;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderDao implements IOrderDao {


    private static OrderDao instance;
    private List<Order> orderList = new ArrayList<>();

    private OrderDao() {
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }


    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
    public List<Order> getOrderList() {
        PreparedStatement preparedStatement = null;
        String sql = "select * from " + Constants.ORDER_TABLE;

        try {
            List<Order> orderList = new ArrayList<>();
            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);

            while (rs.next()) {
                List<Service> serviceList = new ArrayList<>();
                Integer idOrder = (rs.getInt("id"));
                Guest guest = GuestDao.getInstance().findById(rs.getInt("guests"));
                Room room = RoomDao.getInstance().findById(rs.getInt("rooms"));
                LocalDate localDate = (LocalDate) rs.getObject("localDate", LocalDate.class);
                Integer daysOfStay = (rs.getInt("daysOfStay"));
                Integer allAmount = (rs.getInt("allAmount"));
                Order order = new Order(idOrder, guest, room, serviceList, localDate, daysOfStay, allAmount);
                try {
                    preparedStatement = DatabaseHandler.getInstance().getDbConnection()
                            .prepareStatement("select id_service from " + Constants.ORDER_SERVICE_TABLE + " where " + Constants.ORDER_SERVICE_ID_ORDER + "= ?");
                    preparedStatement.setInt(1, idOrder);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Service service = ServiceDao.getInstance().findById((resultSet.getInt("id_service")));
                        serviceList.add(service);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
                order.setServices(serviceList);
                orderList.add(order);
                setOrderList(orderList);
                IdGenerator.setOrderID(idOrder + 1);
            }
            DatabaseHandler.getInstance().getDbConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return new ArrayList<>(orderList);
    }


    @Override
    public void save(Order order) {
        String insert = "insert into "
                + Constants.ORDER_TABLE
                + "(" + Constants.ORDER_ID
                + ","
                + Constants.ORDER_GUEST
                + ","
                + Constants.ORDER_ROOM
                + ","
                + Constants.ORDER_LOCAL_DATE
                + ","
                + Constants.ORDER_DAYS_OF_STAY
                + ","
                + Constants.ORDER_ALL_AMOUNT
                + ")" + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, order.getGuest().getGuestNumber());
            preparedStatement.setInt(3, order.getRoom().getRoomNumber());
            preparedStatement.setDate(4, Date.valueOf(order.getLocalDate()));
            preparedStatement.setInt(5, order.getDaysOfStay());
            preparedStatement.setInt(6, order.getAllAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        String insertOrderService = "insert into "
                + Constants.ORDER_SERVICE_TABLE
                + "(" + Constants.ORDER_SERVICE_ID_ORDER
                + ","
                + Constants.ORDER_SERVICE_ID_SERVICE
                + ")" + "values(?,?)";
        try {
            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insertOrderService);
            List<Service> services = order.getServices();
            for (Service s : services) {
                preparedStatement.setInt(1, order.getId());
                preparedStatement.setInt(2, s.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e + " error");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from " + Constants.ORDER_TABLE + " where " + Constants.ORDER_ID + "=? ;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public Order findById(Integer id) {
        Order order = new Order();
        String sql = "Select * from " + Constants.ORDER_TABLE + " where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                List<Service> serviceList = new ArrayList<>();
                Integer idOrder = (rs.getInt("id"));
                Guest guest = GuestDao.getInstance().findById(rs.getInt("guests"));
                Room room = RoomDao.getInstance().findById(rs.getInt("rooms"));
                LocalDate localDate = rs.getObject("localDate", LocalDate.class);
                Integer daysOfStay = (rs.getInt("daysOfStay"));
                Integer allAmount = (rs.getInt("allAmount"));

                try {
                    preparedStatement = DatabaseHandler.getInstance().getDbConnection()
                            .prepareStatement("select id_service from " + Constants.ORDER_SERVICE_TABLE + " where " + Constants.ORDER_SERVICE_ID_ORDER + "= ?");
                    preparedStatement.setInt(1, idOrder);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Service service = ServiceDao.getInstance().findById((resultSet.getInt("id_service")));
                        serviceList.add(service);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
                order = new Order(idOrder, guest, room, serviceList, localDate, daysOfStay, allAmount);
            }
            DatabaseHandler.getInstance().getDbConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return order;
    }


   @Override
    public void updateOrder(Order order){
       String sql = "UPDATE " + Constants.ORDER_TABLE + " set guests=?,rooms=?,localDate=?,daysOfStay=?,allAmount=?" +
               "  where id=?;";
       PreparedStatement preparedStatement = null;

       try {
           preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
           preparedStatement.setInt(1, order.getGuest().getGuestNumber());
           preparedStatement.setInt(2, order.getRoom().getRoomNumber());
           preparedStatement.setDate(3, Date.valueOf(order.getLocalDate()));
           preparedStatement.setInt(4, order.getDaysOfStay());
           preparedStatement.setInt(5, order.getAllAmount());
           preparedStatement.setInt(6, order.getId());
           preparedStatement.executeUpdate();
           preparedStatement.close();
       } catch (SQLException e) {
           System.err.println(e);
       }
   }

   @Override
    public void addServiceInOrder(Order order,Service service){
       String insert = "insert into "
               + Constants.ORDER_SERVICE_TABLE
               + "(" + Constants.ORDER_SERVICE_ID_ORDER
               + ","
               + Constants.ORDER_SERVICE_ID_SERVICE

               + ")" + "values(?,?)";
       try {
           PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
               preparedStatement.setInt(1, order.getId());
               preparedStatement.setInt(2, service.getId());
               preparedStatement.executeUpdate();

       } catch (SQLException e) {
           System.err.println(e + " error");
       }

   }
   }





