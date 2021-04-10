package com.model;

import com.api.enums.GuestGender;

import java.io.Serializable;

public class Guest implements Serializable {
    private Integer guestNumber;
    private String name;
    private String lastName;
    private Integer age;
    private String phone;
    private GuestGender guestGender;
    private String email;
    private String address;

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

    public Guest(Integer guestNumber, String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address) {
        this.guestNumber = guestNumber;
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
        return "Guest:" + guestNumber + "\n"+
                 name +" " + lastName +", age: " + age +"\n"+
                "phone: " + phone + "  guestGender: " + guestGender+"\n"+
                "email: " + email  +"\n"+
                "address: " + address  +"\n";
    }
}

