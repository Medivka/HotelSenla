package actions.guest;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ShowAllGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "ShowAllGuest");
            fasadGuest.showAllGuests().forEach(System.out::println);
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllGuest");
            System.err.println("ShowAllGuest failed");
        }
    }
}
