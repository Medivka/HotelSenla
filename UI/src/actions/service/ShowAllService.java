package actions.service;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.logging.Level;

public class ShowAllService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadService.showAllService().forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllService");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllService failed");
            System.err.println("ShowAllService failed");
        }
    }
}