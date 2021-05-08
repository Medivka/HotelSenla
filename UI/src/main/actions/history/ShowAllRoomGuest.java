package main.actions.history;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ShowAllRoomGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id guest  : ");
            Integer id = scanner.nextInt();
            fasadHistory.showAllRoomGuest(id).forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllRoomGuest");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllRoomGuest failed");
            System.err.println("ShowAllRoomGuest failed");
        }
    }
}
