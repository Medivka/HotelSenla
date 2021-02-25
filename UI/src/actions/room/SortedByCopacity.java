package actions.room;

import actions.AbstractFasad;
import actions.IAction;

public class SortedByCopacity extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadRoom.sortedByCopacity().forEach(System.out::println);
    }
}