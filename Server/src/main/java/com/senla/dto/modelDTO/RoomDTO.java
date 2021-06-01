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
}
