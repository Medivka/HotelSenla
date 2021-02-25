package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import fasad.FasadRoom;

import java.util.Scanner;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter id Room: ");
        Integer id = scanner.nextInt();
        System.out.println( fasadRoom.findById(id));
    }
}
