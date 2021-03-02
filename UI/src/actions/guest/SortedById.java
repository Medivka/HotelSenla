package actions.guest;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.logging.Level;

public class SortedById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "SortedById");
            fasadGuest.sortedById().forEach(System.out::println);
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "SortedById");
            System.err.println("SortedById failed");
        }
    }
}
