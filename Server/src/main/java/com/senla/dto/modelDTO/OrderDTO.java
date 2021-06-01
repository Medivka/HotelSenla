package com.senla.dto.modelDTO;

import com.senla.model.Guest;
import com.senla.model.Room;
import com.senla.model.Service;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private Integer id;
    private Guest guest;
    private Room room;
    private List<Service> services = new ArrayList<>();
    private LocalDate localDate;
    private Integer daysOfStay;
    private Integer allAmount;
}
