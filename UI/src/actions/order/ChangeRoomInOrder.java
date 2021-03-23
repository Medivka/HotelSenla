package actions.order;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeRoomInOrder extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter OrderNumber: ");
            Integer orderNumber = scanner.nextInt();
            if (fasadOrder.findByID(orderNumber) == null) {
                System.out.println("Order not found \n");
            } else {
                System.out.print("Enter new Room ID: ");
                Integer roomId = scanner.nextInt();
                fasadOrder.changeRoomInOrder(orderNumber, fasadRoom.findById(roomId));
                System.out.println(fasadOrder.findByID(orderNumber));
                LOGGER.log(Level.INFO, String.format("ChangeRoomInOrder order: %s room: %s", orderNumber, roomId));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeRoomInOrder failed");
            System.err.println("ChangeRoomInOrder failed");
        }
    }
}
