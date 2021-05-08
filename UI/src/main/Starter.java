package main;

import com.springConfig.SpringBeans;
import main.menu.MenuController;


public class Starter {
    public static void main(String[] args) {
        SpringBeans.init();
        MenuController.getInstance().run();
    }
}
