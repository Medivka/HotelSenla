package main.menu;


import com.exceptions.ServiceExeption;

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
        Integer count = 1;
        if (currentMenu != null) {
            for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
                MenuItem menuItem = currentMenu.getMenuItems().get(i);
                System.out.print(count++ + " ");
                System.out.println(menuItem);
            }
            System.out.println("0  Exit");
            System.out.print("Enter Number: ");
        }


    }

    public void navigate(Integer index) {
      try{  if (index <= currentMenu.getMenuItems().size() && (index > -1) ) {
            if (currentMenu != null) {
                if(index<=0){
                }else {
                MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
                menuItem.doAction();
                currentMenu = menuItem.getNextMenu();
            }}
        } else System.out.println("!!! Please enter correct Number !!! \n");
    }catch (ServiceExeption e){
          System.err.println("enter incorrect ");}
    }


}
