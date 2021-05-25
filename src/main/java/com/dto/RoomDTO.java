package com.dto;

import com.api.enums.RoomStatus;
import lombok.Data;

import javax.persistence.*;
@Data
public class RoomDTO {

    private Integer id;
    private RoomStatus roomStatus;
    private Integer capacity;
    private Integer price;
    private Integer stars;
}
