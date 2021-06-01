package main.actions.guest;

import com.senla.exceptions.ServiceExeption;
import main.actions.AbstractFasad;
import main.actions.IAction;


import java.util.logging.Level;

public class SortedByName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "SortedByName");
            fasadGuest.sortedByName().forEach(System.out::println);
        } catch (ServiceExeption e) {
            LOGGER.log(Level.INFO, "SortedByName failed");
            System.err.println("SortedByName failed");
        }
    }
}