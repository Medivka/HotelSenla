package com.model;

import java.io.Serializable;

public class Service implements Serializable {

    private Integer id;
    private String name;
    private Integer price;

    public Service() {
    }

    public Service(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Service(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Service " + id + " :" +
                name +
                "   price= " + price+"\n"
                ;
    }


}
