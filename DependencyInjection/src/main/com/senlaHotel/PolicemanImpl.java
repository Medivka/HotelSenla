package main.com.senlaHotel;

import javax.annotation.PostConstruct;


public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("пиф паф, бах бах, кыш, кыш!");
    }
}
