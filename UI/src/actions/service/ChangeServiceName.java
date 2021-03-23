package actions.service;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeServiceName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter id com.service: ");
            Integer id = scanner.nextInt();
            if (fasadService.findByID(id) == null) {
                System.out.println("Service not found \n");
            } else {
                System.out.print("Enter new name: ");
                String name = scanner.next();
                fasadService.changeServiceName(id, name);
                System.out.println(fasadService.findByID(id));
                LOGGER.log(Level.INFO, String.format("ChangeServiceName  id:%s  name: %s", id, name));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeServiceName failed");
            System.err.println("ChangeServiceName failed");
        }
    }
}