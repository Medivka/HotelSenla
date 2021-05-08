package main.actions.room;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.api.enums.RoomStatus;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class CreateRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            RoomStatus roomStatus = RoomStatus.FREE;
            Integer price = 0;
            Integer copacity = 0;
            Integer stars = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose roomstatus: 1.Busy  2.Free 3.Repair ");
            Integer statusId = scanner.nextInt();
            if (statusId.equals(1)) {
                roomStatus = RoomStatus.BUSY;
            }
            if (statusId.equals(2)) {
                roomStatus = RoomStatus.FREE;
            }
            if (statusId.equals(3)) {
                roomStatus = RoomStatus.REPAIRS;
            }
            System.out.print("Enter Copacity :  ");
            copacity = scanner.nextInt();
            System.out.print("Enter Price: ");
            price = scanner.nextInt();
            System.out.print("Enter Stars: ");
            stars = scanner.nextInt();
            System.out.println(fasadRoom.createRoom(roomStatus, copacity, price, stars) + "\n");
            LOGGER.log(Level.INFO, String.format("CreateRoom roomstatus: %s capacity: %s price:%s stars: %s", roomStatus, copacity, price, stars));
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "CreateRoom failed");
            System.err.println("CreateRoom failed");
        }
    }
}
