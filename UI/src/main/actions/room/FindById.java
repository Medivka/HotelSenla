package main.actions.room;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter id Room: ");
            Integer id = scanner.nextInt();
            if (fasadRoom.findById(id) == null) {
                System.out.println("room not found \n");
            } else {
                System.out.println(fasadRoom.findById(id));
                LOGGER.log(Level.INFO, String.format("FindById: %s", id));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "FindById failed");
            System.err.println("FindById failed");
        }
    }
}
