package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import api.enums.RoomStatus;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class ChangeRoomStatus extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        RoomStatus roomStatus = RoomStatus.FREE;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room ID: ");
        Integer roomId = scanner.nextInt();

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
        fasadRoom.changeRoomStatus(roomId, roomStatus);
    }
}
