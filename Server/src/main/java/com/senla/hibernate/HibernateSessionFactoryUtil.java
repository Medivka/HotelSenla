package com.senla.hibernate;

import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    @SneakyThrows
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Guest.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(Room.class);
            configuration.addAnnotatedClass(Service.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
