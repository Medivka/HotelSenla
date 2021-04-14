import com.api.enums.GuestGender;
import com.api.enums.RoomStatus;
import com.api.service.IRoomService;
import com.dao.GuestDao;
import com.dao.OrderDao;
import com.dao.ServiceDao;
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


    public static void main(String[] args) {
        System.out.println(OrderDao.getInstance().findById(5).getServices());

}}
