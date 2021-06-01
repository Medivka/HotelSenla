package com.senla;



import com.senla.springConfig.SpringBeans;

public class Starter {
    public static void main(String[] args) {
        SpringBeans.init();
        SpringBeans.menuController.run();

    }
}
