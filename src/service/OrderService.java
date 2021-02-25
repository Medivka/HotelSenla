package service;

import api.enums.RoomStatus;
import api.service.IOrderService;
import dao.GuestDao;
import dao.HistoryDao;
import dao.OrderDao;
import model.*;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderService implements IOrderService {

    private final OrderDao orderDao;
    private final HistoryDao historyDao;
    private static OrderService instance;
    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService(OrderDao.getInstance(),HistoryDao.getInstance());
        }
        return instance;
    }

    private OrderService(OrderDao orderDao, HistoryDao historyDao) {
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
        History history= new History(IdGenerator.generateHistoryId(),guests,rooms,services,localDate,daysOfStay);
        orderDao.save(order);
        historyDao.save(history);
        return order;
    }

    @Override
    public void addGuestInRoom(Integer orderNumber, Guest guest) {
        Order order = orderDao.findById(orderNumber);
        order.getGuests().add(guest);
        History history= historyDao.findById(orderNumber);
        history.getGuests().add(guest);
           }

    @Override
    public void addInRoomService(Integer orderNumber, Service service) {
        Order order = orderDao.findById(orderNumber);
        order.getServices().add(service);
        History history= historyDao.findById(orderNumber);
        history.getServices().add(service);
           }

    @Override
    public void changeRoomInOrder(Integer orderNumber, Room room) {
        Order order = orderDao.findById(orderNumber);
        order.getRooms().set(0,room);
        History history= historyDao.findById(orderNumber);
        history.getRooms().set(0,room);

    }

    @Override
    public void changeDaysOfStay(Integer orderNumber, Integer daysOfStay) {
        Order order = orderDao.findById(orderNumber);
        order.setDaysOfStay(daysOfStay);
        History history= historyDao.findById(orderNumber);
        history.setDaysOfStay(daysOfStay);
          }

    @Override
    public long getAllAmount(Integer orderNumber) {

            Order order = orderDao.findById(orderNumber);
            List<Room> roomList = order.getRooms();
            Integer amount = 0;
            for (int i = 0; i < roomList.size(); i++) {
                Room room = roomList.get(i);
                amount = amount + room.getPrice();
            }
            for (int i = 0; i < order.getServices().size(); i++) {
                Service service = (Service) order.getServices().get(i);
                amount = amount + service.getPrice();
            }
            return amount*order.getDaysOfStay();

    }
}
