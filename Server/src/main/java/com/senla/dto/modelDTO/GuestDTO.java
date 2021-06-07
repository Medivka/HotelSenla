package com.senla.dto.modelDTO;

import com.senla.api.enums.GuestGender;
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

    @Override
    public String toString() {
        return "Guest:" + guestNumber + "\n" +
                name + " " + lastName + ", age: " + age + "\n" +
                "phone: " + phone + "  guestGender: " + guestGender + "\n" +
                "email: " + email + "\n" +
                "address: " + address + "\n";
}}
