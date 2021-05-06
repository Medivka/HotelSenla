
import com.api.service.IRoomService;
import com.dao.ServiceDao;
import com.model.Service;
import com.service.*;



public class MainProgramm {
    private static IRoomService roomService = RoomService.getInstance();
    private static GuestService guestService = GuestService.getInstance();
    private static ServiceService serviceService = ServiceService.getInstance();
    private static OrderService orderService = OrderService.getInstance();
    private static HistoryService historyService = HistoryService.getInstance();


    public static void main(String[] args) {

ServiceDao serviceDao= ServiceDao.getInstance();
        System.out.println("nenf");
        System.out.println(serviceDao.findById(1));
        System.out.println("sdasdas");
        Service service=new Service("voda",400);
        System.out.println(service);
        serviceDao.save(service);
}}
