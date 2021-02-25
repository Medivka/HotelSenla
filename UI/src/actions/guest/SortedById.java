package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

public class SortedById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadGuest.sortedById().forEach(System.out::println);
    }
}
