package main.actions.history;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.logging.Level;

public class GetAllHistory extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadHistory.getAllHistory().forEach(System.out::println);
            LOGGER.log(Level.INFO, "GetAllHistory");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "GetAllHistory failed");
            System.err.println("GetAllHistory failed");
        }
    }
}
