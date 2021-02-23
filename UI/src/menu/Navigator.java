package menu;

import com.sun.source.tree.BreakTree;

public class Navigator {
    private Navigator instance;



    private Menu currentMenu;


    private Navigator(){}
    public Navigator getInstance(){
        if(instance==null){
            instance= new Navigator();
        }return instance;
    }

    public void printMenu(){}

    public void  navigate(Integer index){
        if(currentMenu!=null){
            MenuItem menuItem=currentMenu.getMenuItems().get(index);
            menuItem.doAction();
            currentMenu=menuItem.getNextMenu();
        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

}
