package actions.history;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class GetFreeLastGuestInRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter room ID: ");
        Integer id= scanner.nextInt();
        fasadHistory.getLastThreeGuestInRoom(id).forEach(System.out::println);
    }
}
