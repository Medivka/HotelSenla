package actions.service;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeServicePrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter id com.service: ");
            Integer id = scanner.nextInt();
            if (fasadService.findByID(id) == null) {
                System.out.println("Service not found \n");
            } else {
                System.out.print("Enter new price: ");
                Integer price = scanner.nextInt();
                fasadService.changeServicePrice(id, price);
                System.out.println(fasadService.findByID(id));
                LOGGER.log(Level.INFO, String.format("ChangeServicePrice id: %s  new price: %s", id, price));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeServicePrice failed");
            System.err.println("ChangeServicePrice failed");
        }
    }
}