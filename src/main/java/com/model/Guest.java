package com.model;

import java.io.Serializable;

public class Guest implements Serializable {
    private String name;
    private Integer guestNumber;
    private Integer age;

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

    public Guest() {
    }

    public Guest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Guest(Integer guestNumber, String name, Integer age) {
        this.name = name;
        this.guestNumber = guestNumber;
        this.age = age;
    }


    @Override
    public String toString() {
        return " Guest " + guestNumber + " : " +
                name +
                ", age=" + age
                ;
    }
}

