package com.dto.modelDTO;

import com.model.Guest;
import com.model.Room;
import com.model.Service;
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
