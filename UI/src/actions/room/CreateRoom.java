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
        System.out.print("Choose roomstatus: 1.Busy  2.Free 3.Repair ");
        Integer statusId = scanner.nextInt();
        if(statusId.equals(1)){ roomStatus = RoomStatus.BUSY;}
        if(statusId.equals(2)){ roomStatus = RoomStatus.FREE;}
        if(statusId.equals(3)){ roomStatus = RoomStatus.REPAIRS;}

        System.out.print("Enter Copacity :  ");
        copacity = scanner.nextInt();
        System.out.print("Enter Price: ");
        price = scanner.nextInt();
        System.out.print("Enter Stars: ");
        stars = scanner.nextInt();
        System.out.println(fasadRoom.createRoom(roomStatus, copacity, price, stars)+ "\n");
    }
}
