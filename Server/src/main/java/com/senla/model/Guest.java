package com.senla.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senla.api.enums.GuestGender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@Entity
@Table(name = "guests")
public class Guest implements Serializable {
    @Id
    @Column(name = "guestNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guestNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone")
    private String phone;
    @Column(name = "guestGender")
    @Enumerated(EnumType.STRING)
    private GuestGender guestGender;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy = "guest", orphanRemoval = true,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Order> orderListGuest=new ArrayList<>();


    public Guest() {
    }

    public Guest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Guest(Integer guestNumber, String name, Integer age) {
        this.guestNumber = guestNumber;
        this.name = name;
        this.age = age;
    }

    public Guest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.guestGender = guestGender;
        this.email = email;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public GuestGender getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(GuestGender guestGender) {
        this.guestGender = guestGender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


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
        Guest guest = (Guest) o;
        return Objects.equals(guestNumber, guest.guestNumber) && Objects.equals(name, guest.name) && Objects.equals(lastName, guest.lastName) && Objects.equals(age, guest.age) && Objects.equals(phone, guest.phone) && guestGender == guest.guestGender && Objects.equals(email, guest.email) && Objects.equals(address, guest.address) && Objects.equals(orderListGuest, guest.orderListGuest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestNumber, name, lastName, age, phone, guestGender, email, address, orderListGuest);
    }
}

