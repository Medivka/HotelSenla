package com.dto;

import com.api.enums.GuestGender;
import lombok.Data;



@Data
public class GuestDTO {
    private Integer guestNumber;
    private String name;
    private String lastName;
    private Integer age;
    private String phone;
    private GuestGender guestGender;
    private String email;
    private String address;

}
