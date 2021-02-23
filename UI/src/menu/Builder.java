package menu;

public class Builder {
    private  static Builder instance;
    private Menu rootMenu;
    private Builder(){}

    public static Builder getInstance(){
        if(instance==null){
            instance= new Builder();
        }return instance;
    }
    public void buildMenu(){}
    public Menu getRootMenu(){
        return rootMenu;
    }


}
