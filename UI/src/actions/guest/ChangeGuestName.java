package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeGuestName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest id: ");
        Integer id = scanner.nextInt();
        System.out.println("Enter new Name Guest: ");
        String name = scanner.nextLine();
        fasadGuest.changeName(id, name);
    }
}
