package com.model;

public class Administrator {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Administrator() {
    }

    public Administrator(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Administrator: " +
                name;
    }
}
