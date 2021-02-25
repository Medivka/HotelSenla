package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import api.enums.RoomStatus;
import java.util.Scanner;

public class CreateRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        RoomStatus roomStatus = RoomStatus.FREE;
        Integer price = 0;
        Integer copacity = 0;
        Integer stars = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose roomstatus: 1.Busy  2.Free 3.Repair ");
        Integer statusId = scanner.nextInt();
        switch (statusId) {
            case (1):
                roomStatus = RoomStatus.BUSY;
            case (2):
                roomStatus = RoomStatus.FREE;
            case (3):
                roomStatus = RoomStatus.REPAIRS;
        }
        System.out.println("Enter Copacity :  ");
        copacity = scanner.nextInt();
        System.out.println("Enter Price: ");
        price = scanner.nextInt();
        System.out.println("Enter Stars: ");
        stars = scanner.nextInt();
        System.out.println(fasadRoom.createRoom(roomStatus, copacity, price, stars));
    }
}
