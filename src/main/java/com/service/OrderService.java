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
import java.util.logging.Level;
import java.util.logging.Logger;


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
        return new ArrayList<>(orderDao.getOrderList());
    }

    @Override
    public Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay) {

        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room);
        ArrayList<Service> services = new ArrayList<>();
        services.add(service);
        Order order = new Order(IdGenerator.generateOrderId(), guests, rooms, services, localDate, daysOfStay);
        History history = new History(IdGenerator.generateHistoryId(), guests, rooms, services, localDate, daysOfStay);
        LOGGER.log(Level.INFO, String.format("createNewOrder id: %s, guest: %s, room: %s, com.service: %s, Date: %s, DayOfStay: %s ", order.getId(), guest, room, service, localDate, daysOfStay));
        orderDao.save(order);
        historyDao.save(history);
        return order;
    }

    @Override
    public Order showOrder(Integer orderNumber) {
        try {
            LOGGER.log(Level.INFO, String.format("showOrder %s", orderNumber));

            Order order = orderDao.findById(orderNumber);
            if (order == null) {
                System.out.println("Order not found \n");
            } else {

            }
            return order;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "showOrder %s ", orderNumber);
            throw new ServiceExeption("showOrder failed", e);
        }
    }

    @Override
    public void addGuestInRoom(Integer orderNumber, Guest guest) {
        try {
            LOGGER.log(Level.INFO, String.format("addGuestInRoom order: %s, guest: %s", guest, orderNumber));
            History history = historyDao.findById(orderNumber);
            Order order = orderDao.findById(orderNumber);
            if (order == null) {
                System.out.println("Order not found  \n");
            } else {
                order.getGuests().add(guest);
//               history.getGuests().add(guest);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "addGuestInRoom failed %s ", orderNumber);
            throw new ServiceExeption("addGuestInRoom failed", e);
        }
    }

    @Override
    public void addInRoomService(Integer orderNumber, Service service) {
        try {
            LOGGER.log(Level.INFO, String.format("addInRoomService order: %s, com.service: %s", orderNumber, service));
            History history = historyDao.findById(orderNumber);
            Order order = orderDao.findById(orderNumber);
            if (order == null) {
                System.out.println("Order not found  \n");
            } else {
                order.getServices().add(service);
//                history.getServices().add(com.service);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "addInRoomService failed %s ", orderNumber);
            throw new ServiceExeption("addInRoomService failed", e);
        }
    }

    @Override
    public void changeRoomInOrder(Integer orderNumber, Room room) {
        try {
            LOGGER.log(Level.INFO, String.format("changeRoomInOrder order: %s, room: %s", orderNumber, room));
            Order order = orderDao.findById(orderNumber);
            History history = historyDao.findById(orderNumber);
            if (order == null) {
                System.out.println("Order not found  \n");
            } else {
                order.getRooms().set(0, room);
//                history.getRooms().set(0, room);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeRoomInOrder %s ", orderNumber);
            throw new ServiceExeption("changeRoomInOrder failed", e);
        }
    }

    @Override
    public void changeDaysOfStay(Integer orderNumber, Integer daysOfStay) {
        try {
            LOGGER.log(Level.INFO, String.format("changeDaysOfStay order: %s, daysOfStay: %s", orderNumber, daysOfStay));
            History history = historyDao.findById(orderNumber);
            Order order = orderDao.findById(orderNumber);
            if (order == null) {

            } else {
                order.setDaysOfStay(daysOfStay);
//               history.setDaysOfStay(daysOfStay);
            }
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeDaysOfStay %s ", orderNumber);
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
            LOGGER.log(Level.WARNING, "findById failed %s ", orderId);
            throw new ServiceExeption("findById failed", e);
        }
    }

    @Override
    public long getAllAmount(Integer orderNumber) {
        try {
            LOGGER.log(Level.INFO, String.format("getAllAmount order: %s", orderNumber));
            Integer amount = 0;
            Order order = orderDao.findById(orderNumber);
            if (order == null) {

            } else {
                List<Room> roomList = order.getRooms();

                for (int i = 0; i < roomList.size(); i++) {
                    Room room = roomList.get(i);
                    amount = amount + room.getPrice();
                }
                for (int i = 0; i < order.getServices().size(); i++) {
                    Service service = (Service) order.getServices().get(i);
                    amount = amount + service.getPrice();

                }
                amount = amount * order.getDaysOfStay();

            }
            return amount;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "getAllAmount failed %s ", orderNumber);
            throw new ServiceExeption("getAllAmount failed", e);
        }
    }
    @Override
    public void deleteOrder(Integer id){
        orderDao.delete(id);
    }

    @Override
    public void setOrderList(List list) {
        orderDao.setOrderList(list);
    }

}
