package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.logging.Level;

public class ShowAllFreeRoom extends AbstractFasad implements IAction {

    @Override
    public void execute() {
        try {
            fasadRoom.allFreeRoom().forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllFreeRoom");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllFreeRoom failed");
            System.err.println("ShowAllFreeRoom failed");
        }
    }
}