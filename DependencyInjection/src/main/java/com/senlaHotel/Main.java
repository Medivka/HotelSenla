package main.java.com.senlaHotel;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        HashMap<Class,Class> asd= new HashMap<>();

        asd.put(People.class,PeopleImpl.class);
        ApplicationContext context = Application.run("main",asd);
        PeopleTestDI peopleTestDI = context.getObject(PeopleTestDI.class);
        peopleTestDI.start();
    }
}
