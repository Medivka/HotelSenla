package com.senla.dao;



import com.senla.api.dao.IGuestDao;
import com.senla.model.Guest;
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
public class GuestDao implements IGuestDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private List<Guest> guestList = new ArrayList<>();

    private GuestDao() {
    }

    @Override
    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public List<Guest> getGuestList() {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Guest> query=criteriaBuilder.createQuery(Guest.class);
        Root<Guest> guestRoot = query.from(Guest.class);
        query.select(guestRoot);
       //        List<Guest> guests = (List<Guest>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Guest").list();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Guest guest) {
        entityManager.remove(guest);
    }

    @Override
    public void save(Guest guest) {
        entityManager.persist(guest);
    }

    @Override
    public Guest findById(Integer id) {
        return entityManager.find(Guest.class, id);

    }

    @Override
    public void update(Guest guest) {
        entityManager.merge(guest);
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.merge(guest);
//        tx1.commit();
//        session.close();
    }
}

/**
 * for jdbc
 * down
 */

//    @Override
//    public void setGuestList(List<Guest> guestList) {
//        this.guestList = guestList;
//    }
//
//    @Override
//    public List<Guest> getGuestList() {
//        String sql = "select * from " + Constants.GUEST_TABLE+";";
//        try {
//            ArrayList<Guest> guests = new ArrayList<>();
//            ResultSet rs = DatabaseHandler.getInstance().getDbConnection().createStatement().executeQuery(sql);
//            while (rs.next()) {
//                GuestGender guestGender;
//                Integer id = (rs.getInt("guestNumber"));
//                String name = (rs.getString("name"));
//                String lastName = (rs.getString("lastName"));
//                Integer age = (rs.getInt("age"));
//                String phone = (rs.getString("phone"));
//                if (rs.getString("guestGender").equals("MALE")) {
//                    guestGender = GuestGender.MALE;
//                } else guestGender = GuestGender.FEMALE;
//                String email = (rs.getString("email"));
//                String address = (rs.getString("address"));
//                Guest guest = new Guest(id, name, lastName, age, phone, guestGender, email, address);
//                guests.add(guest);
//                IdGenerator.setGuestID(id + 1);
//            }
//            setGuestList(guests);
//            DatabaseHandler.getInstance().getDbConnection().close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return new ArrayList<>(guestList);
//    }
//
//
//    @Override
//    public void delete(Integer id) {
//        String sql = "delete from " + Constants.GUEST_TABLE + " where guestNumber=? ";
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
//    public void save(Guest guest) {
//        String insert = "insert into "
//                + Constants.GUEST_TABLE
//                + "(" + Constants.GUEST_GUESTNUMBER
//                + ","
//                + Constants.GUEST_NAME
//                + ","
//                + Constants.GUEST_LASTNAME
//                + ","
//                + Constants.GUEST_AGE
//                + ","
//                + Constants.GUEST_PHONE
//                + ","
//                + Constants.GUEST_GUESTGENDER
//                + ","
//                + Constants.GUEST_EMAIL
//                + ","
//                + Constants.GUEST_ADDRESS + ")" + "values(?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(insert);
//            preparedStatement.setInt(1, guest.getGuestNumber());
//            preparedStatement.setString(2, guest.getName());
//            preparedStatement.setString(3, guest.getLastName());
//            preparedStatement.setInt(4, guest.getAge());
//            preparedStatement.setString(5, guest.getPhone());
//            preparedStatement.setString(6, String.valueOf(guest.getGuestGender()));
//            preparedStatement.setString(7, guest.getEmail());
//            preparedStatement.setString(8, guest.getAddress());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }
//
//
//    @Override
//    public Guest findById(Integer id) {
//        Guest guest = new Guest();
//        String sql = "Select * from " + Constants.GUEST_TABLE + " where guestNumber=?;";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                GuestGender guestGender;
//                Integer guestNumber = (rs.getInt("guestNumber"));
//                String name = (rs.getString("name"));
//                String lastName = (rs.getString("lastName"));
//                Integer age = (rs.getInt("age"));
//                String phone = (rs.getString("phone"));
//                if (rs.getString("guestGender").equals("MALE")) {
//                    guestGender = GuestGender.MALE;
//                } else guestGender = GuestGender.FEMALE;
//                String email = (rs.getString("email"));
//                String address = (rs.getString("address"));
//
//                guest = new Guest(guestNumber, name, lastName, age, phone, guestGender, email, address);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return guest;
//    }
//
//
//    @Override
//    public void update(Guest guest) {
//        String sql = "UPDATE " + Constants.GUEST_TABLE + " set name=?,lastName=?,age=?,phone=?,guestGender=?,email=?,address=?  where guestNumber=?;";//+ guest.getGuestNumber() ;
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DatabaseHandler.getInstance().getDbConnection().prepareStatement(sql);
//            preparedStatement.setString(1, guest.getName());
//            preparedStatement.setString(2, guest.getLastName());
//            preparedStatement.setInt(3, guest.getAge());
//            preparedStatement.setString(4, guest.getPhone());
//            preparedStatement.setString(5, String.valueOf(guest.getGuestGender()));
//            preparedStatement.setString(6, guest.getEmail());
//            preparedStatement.setString(7, guest.getAddress());
//            preparedStatement.setInt(8, guest.getGuestNumber());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("error");
//            System.err.println(e);
//        }
//
//    }
//}
