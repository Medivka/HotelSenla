package actions.room;

import actions.AbstractFasad;
import actions.IAction;

public class SortedByCapacity extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadRoom.sortedByCopacity().forEach(System.out::println);
    }
}