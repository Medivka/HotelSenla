package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeRoomStars extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room ID : ");
            Integer roomId = scanner.nextInt();
            if (fasadRoom.findById(roomId) == null) {
                System.out.println("room not found \n");
            } else {
                System.out.print("Enter new stars: ");
                Integer stars = scanner.nextInt();
                fasadRoom.changeRoomStars(roomId, stars);
                LOGGER.log(Level.INFO, String.format("ChangeRoomStars roomId: %s new stars: %s", roomId, stars));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeRoomStars failed");
            System.err.println("ChangeRoomStars failed");
        }
    }
}
