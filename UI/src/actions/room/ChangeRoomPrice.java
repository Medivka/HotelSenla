package actions.room;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeRoomPrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter room ID : ");
        Integer roomId=scanner.nextInt();
        System.out.println("Enter new copacity: ");
        Integer price=scanner.nextInt();
        fasadRoom.changeRoomPrice(roomId,price);
    }
}
