package actions.guest;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter guest id: ");
            Integer id = scanner.nextInt();
            LOGGER.log(Level.INFO, String.format("FindById:  ", id));
            if (fasadGuest.findById(id) == null) {
                System.out.println("Guest not found  \n");
            } else {
                System.out.println(fasadGuest.findById(id));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "FindById failed");
            System.err.println("FindById failed");
        }
    }
}
