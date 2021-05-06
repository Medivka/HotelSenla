package com.model;

import com.api.enums.RoomStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "rooms")
public class Room implements Serializable {
    @Id
    @Column(name = "roomNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "roomStatus")
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "price")
    private Integer price;
    @Column(name = "stars")
    private Integer stars;

    @OneToMany(mappedBy = "room", orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Order> orderList;


    public Room() {
    }

    public Room(RoomStatus roomStatus, Integer capacity, Integer price, Integer stars) {
        this.roomStatus = roomStatus;
        this.stars = stars;
        this.capacity = capacity;
        this.price = price;
    }


    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getId() {
        return id;
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

    public void setRoomNumber(Integer id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Room " + id + "\n" +
                "roomStatus= " + roomStatus + "\n" +
                "capacity= " + capacity + "\n" +
                "stars= " + stars + "\n" +
                "price= " + price + "\n";
    }
}