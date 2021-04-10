package com.service;

import com.api.service.IOrderService;
import com.dao.HistoryDao;
import com.dao.OrderDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceExeption;
import com.model.*;
import com.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class OrderService implements IOrderService {

    private final OrderDao orderDao;
    private final HistoryDao historyDao;
    private static OrderService instance;
    private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService(OrderDao.getInstance(), HistoryDao.getInstance());
        }
        return instance;
    }

    private OrderService(OrderDao orderDao, HistoryDao historyDao) {
        this.orderDao = orderDao;
        this.historyDao = historyDao;
    }

    @Override
    public List<Order> showAllOrder() {
        LOGGER.log(Level.INFO, String.format("show all Orders"));
        return new ArrayList<>(orderDao.getOrderList());
    }

    @Override
    public Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay) {

        ArrayList<Service> services = new ArrayList<>();
        services.add(service);
        Integer id=IdGenerator.generateOrderId();
        Order order = new Order(id, guest, room,  services, localDate, daysOfStay);
        LOGGER.log(Level.INFO, String.format("createNewOrder id: %s, guest: %s, room: %s, com.service: %s, Date: %s, DayOfStay: %s ", order.getId(), guest, room, service, localDate, daysOfStay));
        orderDao.save(order);
        historyDao.save(order);
        return order;
    }


    @Override
    public void addGuestInRoom(Integer orderNumber, Guest guest) {

            LOGGER.log(Level.INFO, String.format("addGuestInRoom order: %s, guest: %s", guest, orderNumber));

    }

    @Override
    public void addInRoomService(Integer orderNumber, Service service) {
        try {
            LOGGER.log(Level.INFO, String.format("addInRoomService order: %s, com.service: %s", orderNumber, service));
            Order order = orderDao.findById(orderNumber);
            if (order == null) {
                System.out.println("Order not found  \n");
            } else {
                order.getServices().add(service);
                historyDao.findById(orderNumber).getServices().add(service);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "addInRoomService failed ", e);
            throw new ServiceExeption("addInRoomService failed", e);
        }
    }

    @Override
    public void changeRoomInOrder(Integer orderNumber, Room room) {
        try {
            LOGGER.log(Level.INFO, String.format("changeRoomInOrder order: %s, room: %s", orderNumber, room));
            Order order = orderDao.findById(orderNumber);
            if (order == null) {
                System.out.println("Order not found  \n");
            } else {

                historyDao.findById(orderNumber).setRoom(room);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "changeRoomInOrder failed",e);
            throw new ServiceExeption("changeRoomInOrder failed", e);
        }
    }

    @Override
    public void changeDaysOfStay(Integer orderNumber, Integer daysOfStay) {
        try {
            LOGGER.log(Level.INFO, String.format("changeDaysOfStay order: %s, daysOfStay: %s", orderNumber, daysOfStay));
            Order order = orderDao.findById(orderNumber);
            if (order == null) {

            } else {
                order.setDaysOfStay(daysOfStay);
                historyDao.findById(orderNumber).setDaysOfStay(daysOfStay);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "changeDaysOfStay ",e);
            throw new ServiceExeption("changeDaysOfStay failed", e);
        }
    }

    @Override

    public Order findById(Integer orderId) {
        try {
            LOGGER.log(Level.INFO, String.format("findById order: %s", orderId));
            Order order = orderDao.findById(orderId);
            return order;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "findById failed  ",e);
            throw new ServiceExeption("findById failed", e);
        }
    }

    @Override
    public Integer getAllAmount(Integer orderNumber) {
        try {
            LOGGER.log(Level.INFO, String.format("getAllAmount order: %s", orderNumber));
            Integer amount = 0;
            Order order = orderDao.findById(orderNumber);
            if (order == null) {

            } else {
                    amount = amount +  order.getRoom().getPrice();
                }
                for (int i = 0; i < order.getServices().size(); i++) {
                    Service service = (Service) order.getServices().get(i);
                    amount = amount + service.getPrice();
                }
                amount = amount * order.getDaysOfStay();

            return amount;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "getAllAmount failed ", e);
            throw new ServiceExeption("getAllAmount failed", e);
        }
    }
    @Override
    public void deleteOrder(Integer id){
        LOGGER.log(Level.INFO, String.format("delete Order %s", id));
        orderDao.delete(id);
    }

    @Override
    public void setOrderList(List list) {
        LOGGER.log(Level.INFO, String.format("setOrderList"));
        orderDao.setOrderList(list);
    }

}
