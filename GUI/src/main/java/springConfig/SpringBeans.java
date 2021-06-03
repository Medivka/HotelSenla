package springConfig;

import com.senla.api.fasad.*;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.fasad.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeans {

    public static IFasadService fasadService;
    public static IFasadOrder fasadOrder;
    public static IFasadHistory fasadHistory;
    public static IFasadGuest fasadGuest;
    public static IFasadRoom fasadRoom;
    public  static MappingDTOImpl mappingDTOImpl;


    static public void init() {
        ApplicationContext context= new AnnotationConfigApplicationContext(JavaConfig.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        fasadService = context.getBean("fasadService", FasadService.class);
        fasadOrder = context.getBean("fasadOrder", FasadOrder.class);
        fasadHistory=context.getBean("fasadHistory", FasadHistory.class);
        fasadGuest=context.getBean("fasadGuest", FasadGuest.class);
        fasadRoom=context.getBean("fasadRoom", FasadRoom.class);
        mappingDTOImpl =context.getBean("mappingDTO", MappingDTOImpl.class);

    }
}
