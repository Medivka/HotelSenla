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

    @Override
    public String toString() {
        return id + " Order " +
                '\n' + guestDTO.getName() + " " + guestDTO.getLastName() + '\n' +
                "room:  " + roomDTO.getId() + '\n'
                + servicesDTO + '\n' +
                "Day Of  Settling: " + localDate + '\n' +
                "Day Of departure: " + localDate.plusDays(daysOfStay) + "\n" +
                "AllAmount:  " + allAmount + "\n";
    }

}
