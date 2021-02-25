package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class AddInRoomService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter OrderNumber: ");
        Integer orderNumber= scanner.nextInt();
        System.out.println("Enter Service ID: ");
        Integer serviceNumber=scanner.nextInt();
         fasadOrder.AddInRoomService(orderNumber,fasadService.findByID(serviceNumber));

    }
}
