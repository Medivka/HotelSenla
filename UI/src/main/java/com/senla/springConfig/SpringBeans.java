package com.senla.springConfig;

import com.senla.Starter;
import com.senla.api.fasad.*;
import com.senla.dto.mappingDTO.MappingDTO;
import com.senla.fasad.*;
import com.senla.menu.MenuController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeans {

    public static IFasadService fasadService;
    public static IFasadOrder fasadOrder;
    public static IFasadHistory fasadHistory;
    public static IFasadGuest fasadGuest;
    public static IFasadRoom fasadRoom;
    public  static MappingDTO mappingDTO;

   public static MenuController menuController;

    static public void init() {
        ApplicationContext context= new AnnotationConfigApplicationContext(JavaConfig.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        fasadService = context.getBean("fasadService", FasadService.class);
        fasadOrder = context.getBean("fasadOrder", FasadOrder.class);
        fasadHistory=context.getBean("fasadHistory", FasadHistory.class);
        fasadGuest=context.getBean("fasadGuest", FasadGuest.class);
        fasadRoom=context.getBean("fasadRoom", FasadRoom.class);
        mappingDTO=context.getBean("mappingDTO",MappingDTO.class);

        menuController=context.getBean("menuController",MenuController.class);;

    }
}
