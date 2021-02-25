package actions.room;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeRoomStars extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter room ID : ");
        Integer roomId=scanner.nextInt();
        System.out.println("Enter new stars: ");
        Integer stars=scanner.nextInt();
        fasadRoom.changeRoomStars(roomId,stars);
    }
}
