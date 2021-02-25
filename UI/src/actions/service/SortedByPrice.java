package actions.service;

import actions.AbstractFasad;
import actions.IAction;

public class SortedByPrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadService.sortedByPrice().forEach(System.out::println);

    }
}
