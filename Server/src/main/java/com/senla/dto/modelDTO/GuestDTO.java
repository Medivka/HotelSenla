package com.senla.dto.modelDTO;

import com.senla.api.enums.GuestGender;
import lombok.Data;

import java.util.Objects;


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
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestDTO guestDTO = (GuestDTO) o;
        return Objects.equals(guestNumber, guestDTO.guestNumber) && Objects.equals(name, guestDTO.name) && Objects.equals(lastName, guestDTO.lastName) && Objects.equals(age, guestDTO.age) && Objects.equals(phone, guestDTO.phone) && guestGender == guestDTO.guestGender && Objects.equals(email, guestDTO.email) && Objects.equals(address, guestDTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestNumber, name, lastName, age, phone, guestGender, email, address);
    }
}
