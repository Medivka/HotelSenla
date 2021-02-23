package menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems;

    public List<MenuItem> getMenuItems() {
        if(menuItems==null){
            menuItems= new ArrayList<>();
        }
        return menuItems;
    }

    public void addMenuItem(MenuItem item){
       menuItems.add(item);
    }
}
