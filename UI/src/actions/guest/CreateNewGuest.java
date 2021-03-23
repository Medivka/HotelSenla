package actions.guest;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class CreateNewGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();
            System.out.print("Enter guest age: ");
            Integer age = scanner.nextInt();
            System.out.println(fasadGuest.createNewGuest(name, age) + " \n");
            LOGGER.log(Level.INFO, "CreateNewGuest");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.INFO, "CreateNewGuest failed");

            System.err.println("CreateNewGuest failed");
        }
    }
}
