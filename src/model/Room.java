package model;

import api.enums.RoomStatus;
import dao.RoomDao;

public class Room {

    private Integer roomNumber;
    private RoomStatus roomStatus;
    private Integer copacity;
    private Integer price;
    private Integer stars;


    public Integer getStars() { return stars;}
    public void setStars(Integer stars) {this.stars = stars;}
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }
    public Integer getCopacity() {
        return copacity;
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
        this.copacity = copacity;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }


    public Room() {
    }

    public Room(RoomStatus roomStatus, Integer copacity, Integer price,Integer stars) {
        this.roomStatus = roomStatus;
        this.stars=stars;
        this.copacity = copacity;
        this.price = price;
    }

    public Room(Integer roomNumber, RoomStatus roomStatus, Integer copacity, Integer price,Integer stars) {
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
        this.copacity = copacity;
        this.stars=stars;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber +

                ": roomStatus=" + roomStatus +
                ", copacity=" + copacity +", stars=" + stars +
                ", price=" + price;
    }
}