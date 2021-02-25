package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeGuestAge extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter guest id: ");
        Integer id=scanner.nextInt();
        System.out.println("Enter new guest Age: ");
        Integer age= scanner.nextInt();
        fasadGuest.changeGuestAge(id,age);
    }
}
