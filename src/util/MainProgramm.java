package util;

import api.dao.*;
import api.enums.RoomStatus;
import api.service.IRoomService;
import dao.*;
import model.Guest;
import model.Order;
import model.Room;
import model.Service;
import service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainProgramm {
    private static HistoryDao historyDao = new HistoryDao();
    private static GuestDao guestDao = new GuestDao();
    private static RoomDao roomDao = new RoomDao();
    private static AdministratorDao administratorDao = new AdministratorDao();
    private static ServiceDao serviceDao = new ServiceDao();
    private static OrderDao orderDao = new OrderDao();
    private static IRoomService roomService = new RoomService(roomDao);
    private static GuestService guestService = new GuestService(guestDao);
    private static ServiceService serviceService = new ServiceService(serviceDao);
    private static OrderService orderService = new OrderService(orderDao, historyDao);
    private static HistoryService historyService = new HistoryService(historyDao);


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime=LocalDateTime.now();
        Guest guest = guestService.createGuest("Nikolai", 45);
        Guest guest2 = guestService.createGuest("Alexandr", 45);
        Guest guest3 = guestService.createGuest("Kiril", 45);
        Room room = roomService.createRoom(RoomStatus.BUSY, 3, 40,4);
        Room room3 = roomService.createRoom(RoomStatus.FREE, 8, 810,5);
        Service service4 = serviceService.createService("enternet", 2450);


        Order order = orderService.createNewOrder(guest, room3, service4, localDate, 3);

        Order order1 = orderService.createNewOrder(guest2, room, serviceDao.findById(1), localDate, 5);
        Order order2 = orderService.createNewOrder(guest3, room, serviceDao.findById(1), localDate, 5);
        Order order5 = orderService.createNewOrder(guest3, room, serviceDao.findById(1), localDate, 5);
        System.out.println(roomService.allFreeRoom());
        System.out.println( historyService.getThreeLastGuests(1));







    }
}
