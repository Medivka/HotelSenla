package com.senla.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MenuController {

    private Navigator navigator ;
    private Builder builder ;
    @Autowired
    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }




    private MenuController() {
    }



    public void run() {
        try {
            builder.buildMenu();
            Scanner scanner = new Scanner(System.in);
            navigator.setCurrentMenu(builder.getRootMenu());
            navigator.printMenu();
            Boolean menu = true;
            Integer index = 0;

            while (menu) {
                index = scanner.nextInt();
                if (index == 0) {
                    menu = false;
                }
                navigator.navigate(index);
                navigator.printMenu();
            }


        } catch (InputMismatchException e) {
            System.err.println("Sorry, please enter correct");

        }
    }
}
