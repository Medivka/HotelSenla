package main.actions.order;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ShowOrder extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter order number: ");
            Integer orderNumber = scanner.nextInt();
            if (fasadOrder.findByID(orderNumber) == null) {
                System.out.println("Order not found \n");
            } else {
                System.out.println(fasadOrder.findByID(orderNumber));
                LOGGER.log(Level.INFO, String.format("ShowOrder id: %s", orderNumber));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowOrder failed");
            System.err.println("ShowOrder failed");
        }
    }
}
