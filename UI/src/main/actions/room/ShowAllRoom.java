package main.actions.room;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.logging.Level;


public class ShowAllRoom extends AbstractFasad implements IAction {

    @Override
    public void execute() {

        try {
            fasadRoom.showAllRoom().forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllRoom");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllRoom failed");
            System.err.println("ShowAllRoom failed");
        }
    }
}
