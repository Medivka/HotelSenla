package com.senla.dto.modelDTO;


import lombok.Data;


@Data
public class ServiceDTO {

    private Integer id;
    private String name;
    private Integer price;

    @Override
    public String toString() {
        return
                name + "  price= " + price + "\n"
                ;
    }
}
