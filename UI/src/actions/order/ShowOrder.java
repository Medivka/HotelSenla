package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ShowOrder extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter order number: ");
        Integer orderNumber = scanner.nextInt();
        if (fasadOrder.findByID(orderNumber) == null) {
            System.out.println("Order not found \n");
        } else {
            System.out.println(fasadOrder.showOrder(orderNumber));
        }
    }
}
