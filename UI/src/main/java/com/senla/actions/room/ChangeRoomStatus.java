package com.senla.actions.room;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.api.enums.RoomStatus;
import com.senla.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class ChangeRoomStatus extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            RoomStatus roomStatus = RoomStatus.FREE;

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter room ID: ");
            Integer roomId = scanner.nextInt();
            if (fasadRoom.findById(roomId) == null) {
                System.out.println("room not found \n");
            } else {
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
                fasadRoom.changeRoomStatus(roomId, roomStatus);
                LOGGER.log(Level.INFO, String.format("ChangeRoomStatus roomId:%s newRoomStatus: %s", roomId, roomStatus));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeRoomStatus failed");
            System.err.println("ChangeRoomStatus failed");
        }
    }
}
