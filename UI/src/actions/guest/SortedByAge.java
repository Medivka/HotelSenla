package actions.guest;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class SortedByAge extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "SortedByAge ");
            fasadGuest.sortedByAge().forEach(System.out::println);
        } catch (ServiceExeption exeption) {
            LOGGER.log(Level.INFO, "SortedByAge failed ");
            System.err.println("SortedByAge failed");
        }
    }
}

