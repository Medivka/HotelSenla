package com.dao;

import com.api.dao.IServiceDao;
import com.api.enums.GuestGender;
import com.configsDB.Constants;
import com.databaseControllers.DatabaseHandler;
import com.exceptions.DaoException;
import com.fasad.FasadService;
import com.model.Guest;
import com.model.Service;
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

public class ServiceDao implements IServiceDao {

    private List<Service> serviceList = new ArrayList<>();

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    private static ServiceDao instance;

    private ServiceDao() {
    }

    public static ServiceDao getInstance() {
        if (instance == null) {
            instance = new ServiceDao();
        }
        return instance;
    }


    public List<Service> getServiceList() {
        String sql = "select * from " + Constants.SERVICE_TABLE;
        try {
            ArrayList<Service> services = new ArrayList<>();
            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                Integer id = (rs.getInt("id"));
                String name = (rs.getString("name"));
                Integer price = (rs.getInt("price"));
                Service service = new Service(id, name, price);
                services.add(service);
                IdGenerator.setServiceID(id + 1);
            }
            setServiceList(services);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return new ArrayList<>(serviceList);
    }


    @Override
    public void save(Service service) {
        String insert = "insert into "
                + Constants.SERVICE_TABLE
                + "(" + Constants.SERVICE_ID
                + ","
                + Constants.SERVICE_NAME
                + ","
                + Constants.SERVICE_PRICE
                + ")" + " values(?,?,?)";
        try {
            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setString(3, String.valueOf(service.getPrice()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from "+Constants.SERVICE_TABLE+" where id=? ";
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
    public Service findById(Integer id) {
        Service service= new Service();
        String sql = "Select * from "+Constants.SERVICE_TABLE+" where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                Integer idservice = (rs.getInt("id"));
                String name = (rs.getString("name"));
               Integer price = (rs.getInt("price"));
            service=new Service(idservice,name,price);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return service;
    }

}


