package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class GetAllAmount extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter OrderNumber: ");
        Integer orderNumber= scanner.nextInt();
        System.out.println(fasadOrder.getAllAmount(orderNumber));
    }
}
