package main.actions.room;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeRoomPrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room ID : ");
            Integer roomId = scanner.nextInt();
            if (fasadRoom.findById(roomId) == null) {
                System.out.println("room not found \n");
            } else {
                System.out.print("Enter new price: ");
                Integer price = scanner.nextInt();
                fasadRoom.changeRoomPrice(roomId, price);
                LOGGER.log(Level.INFO, String.format("ChangeRoomPrice roomId: %s ,new price: %s", roomId, price));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeRoomPrice failed");
            System.err.println("ChangeRoomPrice failed");
        }
    }
}
