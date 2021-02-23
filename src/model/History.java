package model;

import java.time.LocalDate;
import java.util.List;

public class History {


    private Integer id;
    private List guests;
    private List rooms;
    private List services;
    private LocalDate localDate;
    private Integer daysOfStay;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }
    public List getGuests() {
        return guests;
    }
    public void setGuests(List guests) {
        this.guests = guests;
    }
    public List getRooms() {
        return rooms;
    }
    public void setRooms(List rooms) {
        this.rooms = rooms;
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



    public History() {
    }

    public History(Integer id, List guests, List rooms, List services, LocalDate localDate, Integer daysOfStay) {
        this.id = id;
        this.guests = guests;
        this.rooms = rooms;
        this.services = services;
        this.localDate = localDate;
        this.daysOfStay = daysOfStay;
    }

    @Override
    public String toString() {
        return id + " Order " +
                '\n' + guests +
                ", " + '\n' + rooms +
                ", " + '\n' + services + '\n' +
                "Day Of  Settling: " + localDate + '\n' +
                "Day Of departure: " + localDate.plusDays(daysOfStay) + "\n";
    }
}

