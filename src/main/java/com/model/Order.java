package com.model;

import lombok.Data;



import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   // @Column(name = "guests")

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "guests")
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="rooms")
    private Room room;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "orders_services",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_service"))
    private List<Service> services=new ArrayList<>();

    @Column(name = "localDate")
    private LocalDate localDate;
    @Column(name = "daysOfStay")
    private Integer daysOfStay;
    @Column(name = "allAmount")
    private Integer allAmount;


    public Order() {
    }

    public Order(Guest guest, Room room, List services, LocalDate localDate, Integer daysOfStay, Integer allAmount) {

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
                '\n' + guest.getName() + " " + guest.getLastName() + '\n' +
                "room:  " + room.getId() + '\n'
                + services + '\n' +
                "Day Of  Settling: " + localDate + '\n' +
                "Day Of departure: " + localDate.plusDays(daysOfStay) + "\n" +
                "AllAmount:  " + allAmount + "\n";
    }
}
