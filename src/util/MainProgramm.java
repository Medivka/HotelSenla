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
        Guest guest = guestService.createGuest("Nikolai", 45);
        Guest guest2 = guestService.createGuest("NNNikolai", 45);
        Guest guest3 = guestService.createGuest("NNNNNikolai", 45);
        Room room3 = roomService.createRoom(RoomStatus.REPAIRS, 8, 810);
        Service service4 = serviceService.createService("enternet", 2450);
        Room room = roomService.createRoom(RoomStatus.BUSY, 3, 40);

        Order order = orderService.createNewOrder(guest, room3, service4, localDate, 3);

        Order order1 = orderService.createNewOrder(guest, room, serviceDao.findById(1), localDate, 5);
        orderService.changeRoomInOrder(1, roomService.createRoom(RoomStatus.REPAIRS, 2, 300));
        orderService.addInRoomService(1, serviceService.createService("breakFast", 40));
        orderService.changeDaysOfStay(1, 10);
        orderService.changeRoomInOrder(1, room);
        roomService.changeStatusRoom(3, RoomStatus.BUSY);
        System.out.println(order);

        historyService.shawAllRoomGuest(1);


    }
}
