import com.api.enums.RoomStatus;
import com.api.service.IRoomService;
import com.fasad.FasadOrder;

import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;
import com.service.*;

import java.time.LocalDate;

public class MainProgramm {
    private static IRoomService roomService = RoomService.getInstance();
    private static GuestService guestService = GuestService.getInstance();
    private static ServiceService serviceService = ServiceService.getInstance();
    private static OrderService orderService = OrderService.getInstance();
    private static HistoryService historyService = HistoryService.getInstance();


    public static void main(String[] args)  {

        LocalDate localDate = LocalDate.now();

        Guest guest = guestService.createGuest("Nikolai", 45);
        Guest guest2 = guestService.createGuest("Alexandr", 34);
        Guest guest3 = guestService.createGuest("Kiril", 45);
        Room room = roomService.createRoom(RoomStatus.BUSY, 3, 40, 4);
        Room room3 = roomService.createRoom(RoomStatus.FREE, 8, 810, 5);
        Service service4 = serviceService.createService("enternet", 2450);


        Order order = orderService.createNewOrder(guest, room3, service4, localDate, 3);

        Order order1 = orderService.createNewOrder(guest2, room, serviceService.findById(1), localDate, 5);
        Order order2 = orderService.createNewOrder(guest3, room, serviceService.findById(1), localDate, 5);
        Order order5 = orderService.createNewOrder(guest3, room, serviceService.findById(1), localDate, 5);


        FasadOrder fasadOrder=FasadOrder.getInstance();
        fasadOrder.AddInRoomService(2,serviceService.createService("TV",450));
        System.out.println(fasadOrder.findByID(2));
    }
}
