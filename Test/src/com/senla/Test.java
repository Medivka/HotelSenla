package com.senla;

import com.fasad.FasadGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Autowired
    FasadGuest fasadGuest;
    public void print(){
        System.out.println(fasadGuest.findById(2));
    }

    public static void main(String[] args) {


    }
}
