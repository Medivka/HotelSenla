package com.model;

import com.api.enums.RoomStatus;

import java.io.Serializable;

public class Room implements Serializable {

    private Integer roomNumber;
    private RoomStatus roomStatus;
    private Integer capacity;
    private Integer price;
    private Integer stars;


    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setCopacity(Integer copacity) {
        this.capacity = copacity;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Room() {
    }

    public Room(RoomStatus roomStatus, Integer capacity, Integer price, Integer stars) {
        this.roomStatus = roomStatus;
        this.stars = stars;
        this.capacity = capacity;
        this.price = price;
    }

    public Room(Integer roomNumber, RoomStatus roomStatus, Integer capacity, Integer price, Integer stars) {
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
        this.capacity = capacity;
        this.stars = stars;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber +

                ": roomStatus=" + roomStatus +
                ", capacity=" + capacity + ", stars=" + stars +
                ", price=" + price;
    }
}