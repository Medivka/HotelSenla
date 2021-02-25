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
    private static IRoomService roomService = RoomService.getInstance();
    private static GuestService guestService =GuestService.getInstance();
    private static ServiceService serviceService = ServiceService.getInstance();
    private static OrderService orderService = OrderService.getInstance();
    private static HistoryService historyService =HistoryService.getInstance();


    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        Guest guest = guestService.createGuest("Nikolai", 45);
        Guest guest2 = guestService.createGuest("Alexandr", 34);
        Guest guest3 = guestService.createGuest("Kiril", 45);
        Room room = roomService.createRoom(RoomStatus.BUSY, 3, 40,4);
        Room room3 = roomService.createRoom(RoomStatus.FREE, 8, 810,5);
        Service service4 = serviceService.createService("enternet", 2450);


        Order order = orderService.createNewOrder(guest, room3, service4, localDate, 3);

        Order order1 = orderService.createNewOrder(guest2, room, serviceService.findById(1), localDate, 5);
        Order order2 = orderService.createNewOrder(guest3, room, serviceService.findById(1), localDate, 5);
        Order order5 = orderService.createNewOrder(guest3, room, serviceService.findById(1), localDate, 5);
        System.out.println(guestService.findById(1));
        System.out.println( historyService.getThreeLastGuests(1));
        System.out.println( orderService.getAllAmount(2));







    }
}
