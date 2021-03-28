import com.api.enums.GuestGender;
import com.api.enums.RoomStatus;
import com.api.service.IRoomService;
import com.fasad.FasadOrder;

import com.fasad.FasadService;
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
LocalDate localDate=LocalDate.now();
       Guest guest=GuestService.getInstance().createGuest("Vitia","Somoilov",45,"+375(44)5606666", GuestGender.MALE,"senla@mail.ru","Brest, Ribka st.");
       Guest guest1=GuestService.getInstance().createGuest("Masha","Somoilov",45,"+375(44)5606666", GuestGender.MALE,"senla@mail.ru","Brest, Ribka st.");
       Room room=RoomService.getInstance().createRoom(RoomStatus.FREE,3,500,3);
       Service service= FasadService.getInstance().createNewService("TV",100);
       Order order=FasadOrder.getInstance().createNewOrder(guest,room,service,localDate,3);
       FasadOrder.getInstance().addGuestInRoom(1,guest1);
       System.out.println(order);
    }
}
