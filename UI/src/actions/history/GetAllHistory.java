package actions.history;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
