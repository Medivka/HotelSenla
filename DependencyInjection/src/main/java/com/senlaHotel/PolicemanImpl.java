package main.java.com.senlaHotel;


public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("пиф паф, бах бах, кыш, кыш!");
    }
}
