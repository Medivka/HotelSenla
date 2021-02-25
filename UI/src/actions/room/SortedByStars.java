package actions.room;

import actions.AbstractFasad;
import actions.IAction;

public class SortedByStars extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadRoom.sortedByStars().forEach(System.out::println);
    }
}