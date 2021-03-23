package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeRoomCapacity extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room ID : ");
            Integer roomId = scanner.nextInt();
            if (fasadRoom.findById(roomId) == null) {
                System.out.println("room not found \n");
            } else {
                System.out.print("Enter new capacity: ");
                Integer capacity = scanner.nextInt();
                fasadRoom.changeRoomCopacity(roomId, capacity);
                LOGGER.log(Level.INFO, String.format("ChangeRoomCapacity roomId: %s new capacity: %s", roomId, capacity));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeRoomCapacity failed");
            System.err.println("ChangeRoomCapacity failed");
        }
    }
}
