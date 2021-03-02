package actions.guest;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeGuestAge extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter guest id: ");
            Integer id = scanner.nextInt();
            if (fasadGuest.findById(id) == null) {
                System.out.println("Guest not found  \n");
            } else {
                System.out.print("Enter new guest Age: ");
                Integer age = scanner.nextInt();
                fasadGuest.changeGuestAge(id, age);
                System.out.println(fasadGuest.findById(id));
                LOGGER.log(Level.INFO, String.format("ChangeGuestAge guest: %s  age: %s", id, age));
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "ChangeGuestAge failed");

            System.err.println("ChangeGuestAge failed");

        }
    }
}
