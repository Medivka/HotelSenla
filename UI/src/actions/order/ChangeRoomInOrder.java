package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeRoomInOrder extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter OrderNumber: ");
        Integer orderNumber = scanner.nextInt();
        System.out.println("Enter new Room ID: ");
        Integer roomId = scanner.nextInt();
        fasadOrder.changeRoomInOrder(orderNumber, fasadRoom.findById(roomId));
    }
}
