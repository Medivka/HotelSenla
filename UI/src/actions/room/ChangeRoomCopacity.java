package actions.room;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeRoomCopacity extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter room ID : ");
        Integer roomId=scanner.nextInt();
        System.out.println("Enter new copacity: ");
        Integer copacity=scanner.nextInt();
        fasadRoom.changeRoomCopacity(roomId,copacity);
    }
}
