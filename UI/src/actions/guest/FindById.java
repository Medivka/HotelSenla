package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter guest id: ");
        Integer id = scanner.nextInt();
        if (fasadGuest.findById(id) == null) {
            System.out.println("Guest not found  \n");
        } else {
            System.out.println(fasadGuest.findById(id));
        }
    }
}
