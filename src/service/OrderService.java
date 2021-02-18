package service;

import api.enums.RoomStatus;
import api.service.IOrderService;
import dao.HistoryDao;
import dao.OrderDao;
import model.Guest;
import model.Order;
import model.Room;
import model.Service;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;


public class OrderService implements IOrderService {

    private final OrderDao orderDao;
    private final HistoryDao historyDao;

    public OrderService(OrderDao orderDao, HistoryDao historyDao) {
        this.orderDao = orderDao;
        this.historyDao = historyDao;
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
        orderDao.save(order);
        historyDao.save(order);
        return order;
    }

    @Override
    public void addGuestInRoom(Integer orderNumber, Guest guest) {
        Order order1 = orderDao.findById(orderNumber);
        order1.getGuests().add(guest);
        historyDao.save(order1);
    }

    @Override
    public void addInRoomService(Integer orderNumber, Service service) {
        Order order = orderDao.findById(orderNumber);
        order.getServices().add(service);
        historyDao.save(order);
    }

    @Override
    public void changeRoomInOrder(Integer orderNumber, Room room) {
        Order order = orderDao.findById(orderNumber);
        order.getRooms().set(0, room);
        historyDao.save(order);
    }

    @Override
    public void changeDaysOfStay(Integer orderNumber, Integer daysOfStay) {
        Order order = orderDao.findById(orderNumber);
        order.setDaysOfStay(daysOfStay);
        historyDao.save(order);
    }

    @Override
    public long getAllAmount(Integer orderNumber) {
        Order order = orderDao.findById(orderNumber);

        Integer amount = 0;
        for (int i = 0; i < order.getRooms().size(); i++) {
            Room room = (Room) order.getRooms().get(i);
            amount = amount + room.getPrice();
        }
        for (int i = 0; i < order.getServices().size(); i++) {
            Service service = (Service) order.getServices().get(i);
            amount = amount + service.getPrice();
        }
        return amount;
    }
}
