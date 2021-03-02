package actions.history;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class GetThreeLastGuestInRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter room ID: ");
            Integer id = scanner.nextInt();
            fasadHistory.getLastThreeGuestInRoom(id).forEach(System.out::println);
            LOGGER.log(Level.INFO, "GetThreeLastGuestInRoom idRoom");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "GetThreeLastGuestInRoom failed");
            System.err.println("GetThreeLastGuestInRoom failed");
        }
    }
}
