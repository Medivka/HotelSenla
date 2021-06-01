package main.java.com.senlaHotel;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        HashMap<Class,Class> asd= new HashMap<>();
        asd.put(Policeman.class,PolicemanImpl.class);
        asd.put(People.class,PeopleImpl.class);
        ApplicationContext context = Application.run("main",asd);
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
