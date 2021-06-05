package com.senla.service;

import com.senla.api.dao.IHistoryDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.service.IOrderService;
import com.senla.dao.HistoryDao;
import com.senla.dao.OrderDao;
import com.senla.exceptions.DaoException;
import com.senla.exceptions.ServiceExeption;
import com.senla.model.Guest;
import com.senla.model.Room;
import com.senla.model.Service;
import com.senla.model.Order;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    IOrderDao orderDao;
    @Autowired
    IHistoryDao historyDao;

    private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());

    @Autowired
    private OrderService(OrderDao orderDao, HistoryDao historyDao) {
        this.orderDao = orderDao;
        this.historyDao = historyDao;
    }

    @Override
    public List<Order> showAllOrder() {
        LOGGER.log(Level.INFO, String.format("show all Orders"));
        return new ArrayList<>(orderDao.getOrderList());
    }

    public void orderUpdateAllAmount(Integer orderNumber) {
        Order order = orderDao.findById(orderNumber);
        order.setAllAmount(getAllAmount(orderNumber));

    }

    @Override
    public Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay) {
        Integer priceService = 0;
        ArrayList<Service> services = new ArrayList<>();
        services.add(service);

        for (int i = 0; i < services.size(); i++) {
            Service service1 = services.get(i);
            priceService = priceService + service1.getPrice();
        }
        Integer priceRoom = room.getPrice();
        Integer allAmount = (priceRoom + priceService) * daysOfStay;
        Order order = new Order(guest, room, services, localDate, daysOfStay, allAmount);
        LOGGER.log(Level.INFO, String.format("createNewOrder id: %s, guest: %s, room: %s, com.service: %s, Date: %s, DayOfStay: %s ,AllAmount: %s ", order.getId(), guest, room, service, localDate, daysOfStay, order.getAllAmount()));
        orderDao.save(order);
        historyDao.save(order);
        return order;
    }


    @Override
    public void addGuestInRoom(Integer orderNumber, Guest guest) {
        LOGGER.log(Level.INFO, String.format("addGuestInRoom order: %s, guest: %s", guest, orderNumber));

    }

    @Override
    public void addServiceInOrder(Order order, Service service) {
        try {
            LOGGER.log(Level.INFO, String.format("addServiceInOrder order: %s, service: %s", order.getId(), service.getId()));
            orderDao.addServiceInOrder(order, service);
            orderUpdateAllAmount(order.getId());
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "addServiceInOrder failed ", e);
            throw new ServiceExeption("addServiceInOrder failed", e);
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
            LOGGER.log(Level.WARN, "changeRoomInOrder failed", e);
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
            LOGGER.log(Level.WARN, "changeDaysOfStay ", e);
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
            LOGGER.log(Level.WARN, "findById failed  ", e);
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
                amount = amount + order.getRoom().getPrice();
            }

            if (order.getServices().size() == 0) {
            } else {
                for (int i = 0; i < order.getServices().size(); i++) {
                    Service service = (Service) order.getServices().get(i);
                    amount = amount + service.getPrice();
                }
                amount = amount * order.getDaysOfStay();
            }

            return amount;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "getAllAmount failed ", e);
            throw new ServiceExeption("getAllAmount failed", e);
        }
    }

    @Override
    public void deleteOrder(Order order) {
        LOGGER.log(Level.INFO, String.format("delete Order %s", order.getId()));
        orderDao.delete(order);
    }

    @Override
    public void setOrderList(List list) {
        LOGGER.log(Level.INFO, String.format("setOrderList"));
        orderDao.setOrderList(list);
    }

    @Override
    public void updateOrder(Order order) {
        LOGGER.log(Level.INFO, String.format("update order"));
        orderUpdateAllAmount(order.getId());
        orderDao.updateOrder(order);
    }

    @Override
    public void save(Order order) {
        LOGGER.log(Level.INFO, String.format("save order"));
        orderDao.save(order);
    }

}
