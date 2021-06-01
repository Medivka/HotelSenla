package main;



import main.menu.MenuController;
import main.springConfig.SpringBeans;


public class Starter {
    public static void main(String[] args) {
        SpringBeans.init();
        MenuController.getInstance().run();
    }
}
