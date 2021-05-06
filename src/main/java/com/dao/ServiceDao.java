package com.dao;

import com.api.dao.IServiceDao;
import com.hibernate.HibernateSessionFactoryUtil;
import com.model.Guest;
import com.model.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class ServiceDao implements IServiceDao {


    private List<Service> serviceList = new ArrayList<>();

    private static ServiceDao instance;

    private ServiceDao() {
    }

    public static ServiceDao getInstance() {
        if (instance == null) {
            instance = new ServiceDao();
        }
        return instance;
    }

    @Override
    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public List<Service> getServiceList() {
        List<Service> services = (List<Service>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Service").list();
        return services;
    }

    @Override
    public void save(Service service) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(service);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Service service) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(service);
        tr.commit();
        session.close();
    }


    @Override
    public Service findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Service service= session.get(Service.class,id);
        session.close();
        return service;
    }


    @Override
    public void updateService(Service service) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.merge(service);
        tr.commit();
        session.close();
    }
}
/**
 * for jdbc
 * down
 */
//    @Override
//    public void setServiceList(List<Service> serviceList) {
//        this.serviceList = serviceList;
//    }
//
//    @Override
//    public List<Service> getServiceList() {
//        String sql = "select * from " + Constants.SERVICE_TABLE;
//        try {
//            ArrayList<Service> services = new ArrayList<>();
//            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);
//            while (rs.next()) {
//                Integer id = (rs.getInt("id"));
//                String name = (rs.getString("name"));
//                Integer price = (rs.getInt("price"));
//                Service service = new Service(id, name, price);
//                services.add(service);
//                IdGenerator.setServiceID(id + 1);
//            }
//            setServiceList(services);
//            rs.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return new ArrayList<>(serviceList);
//    }
//
//
//    @Override
//    public void save(Service service) {
//        String insert = "insert into "
//                + Constants.SERVICE_TABLE
//                + "(" + Constants.SERVICE_ID
//                + ","
//                + Constants.SERVICE_NAME
//                + ","
//                + Constants.SERVICE_PRICE
//                + ")" + " values(?,?,?)";
//        try {
//            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
//            preparedStatement.setInt(1, service.getId());
//            preparedStatement.setString(2, service.getName());
//            preparedStatement.setString(3, String.valueOf(service.getPrice()));
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }
//
//    @Override
//    public void delete(Integer id) {
//        String sql = "delete from " + Constants.SERVICE_TABLE + " where id=? ";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }
//
//    @Override
//    public Service findById(Integer id) {
//        Service service = new Service();
//        String sql = "Select * from " + Constants.SERVICE_TABLE + " where id=?";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Integer idService = (rs.getInt("id"));
//                String name = (rs.getString("name"));
//                Integer price = (rs.getInt("price"));
//                service = new Service(idService, name, price);
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return service;
//    }
//
//    @Override
//    public void updateService(Service service) {
//        String sql = "UPDATE " + Constants.SERVICE_TABLE + " set name=? ,price=?  where id=?;";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(3, service.getId());
//            preparedStatement.setString(1, service.getName());
//            preparedStatement.setInt(2, service.getPrice());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }



