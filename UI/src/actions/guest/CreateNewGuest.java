package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class CreateNewGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest name: ");
        String name = scanner.nextLine();
        System.out.println("Enter guest age: ");
        Integer age = scanner.nextInt();
        fasadGuest.createNewGuest(name, age);
    }
}
