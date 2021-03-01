package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class AddInRoomService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
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
        }
    }
}
