package actions.room;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeRoomStars extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room ID : ");
        Integer roomId = scanner.nextInt();
        if (fasadRoom.findById(roomId) == null) {
            System.out.println("room not found \n");
        } else {
            System.out.print("Enter new stars: ");
            Integer stars = scanner.nextInt();
            fasadRoom.changeRoomStars(roomId, stars);
        }
    }
}
