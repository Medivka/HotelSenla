package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.logging.Level;

public class SortedByCapacity extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadRoom.sortedByCopacity().forEach(System.out::println);
            LOGGER.log(Level.INFO, "SortedByCapacity");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "SortedByCapacity failed");
            System.err.println("SortedByCapacity failed");
        }
    }
}