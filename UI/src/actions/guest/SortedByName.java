package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

public class SortedByName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadGuest.sortedByName().forEach(System.out::println);
    }}