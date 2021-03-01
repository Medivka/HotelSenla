package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeRoomInOrder extends AbstractFasad implements IAction {
    @Override
    public void execute() {
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
        }
    }
}
