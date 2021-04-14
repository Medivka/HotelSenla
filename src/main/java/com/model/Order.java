package com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Order implements Serializable {

    private Integer id;
    private Guest guest;
    private Room room;
    private List services;
    private LocalDate localDate;
    private Integer daysOfStay;
    private Integer allAmount;




    public Order() {
    }

    public Order(Integer id, Guest guest, Room room, List services, LocalDate localDate, Integer daysOfStay, Integer allAmount) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.services = services;
        this.localDate = localDate;
        this.daysOfStay = daysOfStay;
        this.allAmount = allAmount;
    }

    public Integer getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(Integer allAmount) {
        this.allAmount = allAmount;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room rooms) {
        this.room = rooms;
    }

    public List getServices() {
        return services;
    }

    public void setServices(List services) {
        this.services = services;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Integer getDaysOfStay() {
        return daysOfStay;
    }

    public void setDaysOfStay(Integer daysOfStay) {
        this.daysOfStay = daysOfStay;
    }


    @Override
    public String toString() {
        return id + " Order " +
                '\n' + guest.getName() +" "+guest.getLastName()+ '\n'+
                "room:  " + room.getRoomNumber()+ '\n'
                + services + '\n' +
                "Day Of  Settling: " + localDate + '\n' +
                "Day Of departure: " + localDate.plusDays(daysOfStay) + "\n" +
                "AllAmount:  "+  allAmount+ "\n";
    }
}
