package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AddGuestInRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OrderNumber: ");
        Integer orderNumber = scanner.nextInt();
        if (fasadOrder.findByID(orderNumber) == null) {
            System.out.println("Order not found \n");
        } else {
            System.out.print("Enter GuestID: ");
            Integer guestNumber = scanner.nextInt();
            fasadOrder.addGuestInRoom(orderNumber, fasadGuest.findById(guestNumber));
            System.out.println(fasadOrder.findByID(orderNumber));
        }
    }
}
