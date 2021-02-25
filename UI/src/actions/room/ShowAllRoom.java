package actions.room;

import actions.AbstractFasad;
import actions.IAction;


public class ShowAllRoom extends AbstractFasad implements IAction {

    @Override
    public void execute() {
        fasadRoom.showAllRoom().forEach(System.out::println);
    }
}
