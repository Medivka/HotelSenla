package actions.service;

import actions.AbstractFasad;
import actions.IAction;

public class ShowAllService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadService.showAllService().forEach(System.out::println);

    }
}