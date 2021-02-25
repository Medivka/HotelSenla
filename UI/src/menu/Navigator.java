package menu;


import java.util.ArrayList;
import java.util.Collection;

public class Navigator {
    private static Navigator instance;
    private Menu currentMenu;

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
    private Navigator() {
    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    public void printMenu() {
        if (currentMenu != null) {

            for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
                MenuItem menuItem = currentMenu.getMenuItems().get(i);
                System.out.print(i+ " ");
                System.out.println( menuItem);

            }
            System.out.println("Enter Number: ");
        }

    }

    public void navigate(Integer index) {
        if (currentMenu != null) {
            MenuItem menuItem = currentMenu.getMenuItems().get(index);
            menuItem.doAction();
            currentMenu = menuItem.getNextMenu();
        }
    }



}
