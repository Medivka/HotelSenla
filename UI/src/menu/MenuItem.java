package menu;

import actions.IAction;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu nextMenu;
    public Menu getNextMenu() {
        return nextMenu;
    }


    public void doAction() {


    }

    public MenuItem(String title, Menu nextMenu) {
        this.title = title;
        this.nextMenu = nextMenu;
    }

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }



    @Override
    public String toString() {
        return " " +
                " " + title +
                " nextMenu= " + nextMenu;
    }

}
