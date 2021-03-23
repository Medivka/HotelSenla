package actions.order;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

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
                fasadOrder.AddInRoomService(orderNumber, fasadService.findByID(serviceNumber));
                System.out.println(fasadOrder.findByID(orderNumber));
                LOGGER.log(Level.INFO, String.format("AddInRoomService order: %s com.service: %s", orderNumber, serviceNumber));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "AddInRoomService failed");
            System.err.println("AddInRoomService failed");
        }
    }
}
