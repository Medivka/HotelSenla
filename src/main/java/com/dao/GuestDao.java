package com.dao;

import com.api.dao.IGuestDao;
import com.api.enums.GuestGender;
import com.configsDB.Constants;
import com.databaseControllers.DatabaseHandler;
import com.exceptions.DaoException;
import com.fasad.FasadGuest;
import com.model.Guest;
import com.util.IdGenerator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDao implements IGuestDao {


    private static GuestDao instance;
    private List<Guest> guestList = new ArrayList<>();

    private GuestDao() {
    }

    public static GuestDao getInstance() {
        if (instance == null) {
            instance = new GuestDao();
        }
        return instance;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public List<Guest> getGuestList() {
        String sql = "select * from "+Constants.GUEST_TABLE;
        try {
            ArrayList<Guest> guests = new ArrayList<>();
            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                GuestGender guestGender;
                Integer id = (rs.getInt("guestNumber"));
                String name = (rs.getString("name"));
                String lastName = (rs.getString("lastName"));
                Integer age = (rs.getInt("age"));
                String phone = (rs.getString("phone"));
                if (rs.getString("guestGender").equals("MALE")) {
                    guestGender = GuestGender.MALE;
                } else guestGender = GuestGender.FEMALE;
                String email = (rs.getString("email"));
                String address = (rs.getString("address"));

                Guest guest = new Guest(id, name, lastName, age, phone, guestGender, email, address);
                guests.add(guest);
                IdGenerator.setGuestID(id + 1);
            }
            setGuestList(guests);
            DatabaseHandler.getInstance().getDbConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return new ArrayList<>(guestList);
    }


    @Override
    public void delete(Integer id) {
        String sql = "delete from "+Constants.GUEST_TABLE+" where guestNumber=? ";
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
    public void save(Guest guest) {
        String insert = "insert into "
                + Constants.GUEST_TABLE
                + "(" + Constants.GUEST_GUESTNUMBER
                + ","
                + Constants.GUEST_NAME
                + ","
                + Constants.GUEST_LASTNAME
                + ","
                + Constants.GUEST_AGE
                + ","
                + Constants.GUEST_PHONE
                + ","
                + Constants.GUEST_GUESTGENDER
                + ","
                + Constants.GUEST_EMAIL
                + ","
                + Constants.GUEST_ADDRESS + ")" + "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, guest.getGuestNumber());
            preparedStatement.setString(2, guest.getName());
            preparedStatement.setString(3, guest.getLastName());
            preparedStatement.setInt(4, guest.getAge());
            preparedStatement.setString(5, guest.getPhone());
            preparedStatement.setString(6, String.valueOf(guest.getGuestGender()));
            preparedStatement.setString(7, guest.getEmail());
            preparedStatement.setString(8, guest.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }


    @Override
    public Guest findById(Integer id) {
        Guest guest = new Guest();
        String sql = "Select * from "+Constants.GUEST_TABLE+" where guestNumber=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                GuestGender guestGender;
                Integer guestNumber = (rs.getInt("guestNumber"));
                String name = (rs.getString("name"));
                String lastName = (rs.getString("lastName"));
                Integer age = (rs.getInt("age"));
                String phone = (rs.getString("phone"));
                if (rs.getString("guestGender").equals("MALE")) {
                    guestGender = GuestGender.MALE;
                } else guestGender = GuestGender.FEMALE;
                String email = (rs.getString("email"));
                String address = (rs.getString("address"));

                guest = new Guest(guestNumber, name, lastName, age, phone, guestGender, email, address);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return guest;
    }


    @Override
    public void update(Guest guest) {

        String sql = "update senlahotel.guests set name=?,lastName=?,age=?,phone=?,guestGender=?,email=?,address=?  where guestNumber=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, guest.getGuestNumber());
            preparedStatement.setString(2, guest.getName());
            preparedStatement.setString(3, guest.getLastName());
            preparedStatement.setInt(4, guest.getAge());
            preparedStatement.setString(5, guest.getPhone());
            preparedStatement.setString(6, String.valueOf(guest.getGuestGender()));
            preparedStatement.setString(7, guest.getEmail());
            preparedStatement.setString(8, guest.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
