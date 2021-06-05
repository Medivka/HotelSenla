package com.senla.dto.modelDTO;


import lombok.Data;

import java.time.LocalDate;

import java.util.List;

@Data
public class OrderDTO {
    private Integer id;
    private GuestDTO guestDTO;
    private RoomDTO roomDTO;
    private List<ServiceDTO> servicesDTO;
    private LocalDate localDate;
    private Integer daysOfStay;
    private Integer allAmount;
}
