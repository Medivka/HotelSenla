package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class SortedByPrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadRoom.sortedByPrice().forEach(System.out::println);
            LOGGER.log(Level.INFO, "SortedByPrice");

        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "SortedByPrice failed");
            System.err.println("SortedByPrice failed");
        }
    }
}