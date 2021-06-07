package com.senla.dto.modelDTO;

import com.senla.api.enums.RoomStatus;
import lombok.Data;

@Data
public class RoomDTO {

    private Integer id;
    private RoomStatus roomStatus;
    private Integer capacity;
    private Integer price;
    private Integer stars;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
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
