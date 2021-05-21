package com.springConfig;

import com.api.fasad.*;
import com.fasad.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeans {

    public static IFasadService fasadService;
    public static IFasadOrder fasadOrder;
    public static IFasadHistory fasadHistory;
    public static IFasadGuest fasadGuest;
    public static IFasadRoom fasadRoom;


    static public void init() {
        ApplicationContext context= new AnnotationConfigApplicationContext(JavaConfig.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        fasadService = context.getBean("fasadService", FasadService.class);
        fasadOrder = context.getBean("fasadOrder", FasadOrder.class);
        fasadHistory=context.getBean("fasadHistory", FasadHistory.class);
        fasadGuest=context.getBean("fasadGuest", FasadGuest.class);
        fasadRoom=context.getBean("fasadRoom", FasadRoom.class);
    }
}
