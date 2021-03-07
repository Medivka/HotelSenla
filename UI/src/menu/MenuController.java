package menu;

import exceptions.ServiceExeption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    private static MenuController instance;
    private Builder builder = Builder.getInstance();
    private Navigator navigator = Navigator.getInstance();


    private MenuController() {
    }


    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
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
