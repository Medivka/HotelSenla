package actions.room;

import actions.AbstractFasad;
import actions.IAction;

public class ShowAllFreeRoom extends AbstractFasad implements IAction {

    @Override
    public void execute() {

       fasadRoom.allFreeRoom().forEach(System.out::println);
    }
}