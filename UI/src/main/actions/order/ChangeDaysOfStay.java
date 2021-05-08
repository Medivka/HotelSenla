package main.actions.order;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeDaysOfStay extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter OrderNumber: ");
            Integer orderNumber = scanner.nextInt();
            if (fasadOrder.findByID(orderNumber) == null) {
                System.out.println("Order not found \n");
            } else {
                System.out.print("Enter new days of stay ");
                Integer daysOfStay = scanner.nextInt();
                fasadOrder.changeDaysOfStay(orderNumber, daysOfStay);
                System.out.println(fasadOrder.findByID(orderNumber));
                LOGGER.log(Level.INFO, String.format("ChangeDaysOfStay order: %s days: %s", orderNumber, daysOfStay));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeDaysOfStay failed");
            System.err.println("ChangeDaysOfStay failed");
        }
    }
}
