package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ShowAllGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadGuest.showAllGuests().forEach(System.out::println);
    }
}
