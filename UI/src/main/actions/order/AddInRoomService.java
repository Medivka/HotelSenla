package main.actions.order;

import com.senla.exceptions.ServiceExeption;
import main.actions.AbstractFasad;
import main.actions.IAction;


import java.util.Scanner;
import java.util.logging.Level;

public class AddInRoomService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter OrderNumber: ");
            Integer orderNumber = scanner.nextInt();
            if (fasadOrder.findByID(orderNumber) == null) {
                System.out.println("Order not found \n");
            } else {
                System.out.print("Enter Service ID: ");
                Integer serviceNumber = scanner.nextInt();
               // fasadOrder.AddInRoomService(orderNumber, fasadService.findById(serviceNumber));
                System.out.println(fasadOrder.findByID(orderNumber));
                LOGGER.log(Level.INFO, String.format("AddInRoomService order: %s com.service: %s", orderNumber, serviceNumber));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "AddInRoomService failed");
            System.err.println("AddInRoomService failed");
        }
    }
}
