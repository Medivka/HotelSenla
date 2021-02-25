package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AddGuestInRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter OrderNumber: ");
        Integer orderNumber= scanner.nextInt();
        System.out.println("Enter GuestID: ");
        Integer guestNumber=scanner.nextInt();
        fasadOrder.addGuestInRoom(orderNumber,fasadGuest.findById(guestNumber));
    }
}
