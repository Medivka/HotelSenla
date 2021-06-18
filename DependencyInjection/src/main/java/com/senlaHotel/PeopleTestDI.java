package main.java.com.senlaHotel;


@Singleton
public class PeopleTestDI {

    @InjectByType
    private Announcer announcer;

    @InjectByType
    private People people;



    public void start() {
        announcer.announce("it is good?");
        desinfect();
        people.launch();
        announcer.announce("yes");
    }



    private void desinfect(){
        System.out.println("all right");
    }
}
