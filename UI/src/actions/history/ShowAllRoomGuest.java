package actions.history;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ShowAllRoomGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id guest  : ");
        Integer id = scanner.nextInt();
        fasadHistory.showAllRoomGuest(id).forEach(System.out::println);

    }
}
