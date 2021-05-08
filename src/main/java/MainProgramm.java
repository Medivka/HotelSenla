import com.api.dao.IGuestDao;
import com.api.fasad.IFasadOrder;
import com.api.fasad.IFasadService;
import com.api.service.IHistoryService;

import com.dao.GuestDao;
import com.fasad.FasadOrder;
import com.fasad.FasadService;
import com.service.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainProgramm {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IGuestDao guestDao=context.getBean("guestDao", GuestDao.class);
        IHistoryService historyService=context.getBean("historyService",HistoryService.class);
        IFasadService fasadService=context.getBean("fasadService", FasadService.class);
        IFasadOrder fasadOrder=context.getBean("fasadOrder", FasadOrder.class);

        System.out.println(fasadOrder.findByID(1));
}}
