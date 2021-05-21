package com.dao;

import com.api.dao.IServiceDao;

import com.model.Service;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceDao implements IServiceDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private List<Service> serviceList = new ArrayList<>();

      private ServiceDao() {
    }


    @Override
    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public List<Service> getServiceList() {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Service> query=criteriaBuilder.createQuery(Service.class);
        Root<Service> serviceRoot = query.from(Service.class);
        query.select(serviceRoot);
        return entityManager.createQuery(query).getResultList();    }

    @Override
    public void save(Service service) {
        entityManager.persist(service);
    }

    @Override
    public void delete(Service service) {
       entityManager.remove(service);
    }


    @Override
    public Service findById(Integer id) {
       return entityManager.find(Service.class,id);
    }


    @Override
    public void updateService(Service service) {
       entityManager.merge(service);
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



