package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import fasad.FasadRoom;

import java.util.Scanner;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id Room: ");

        Integer id = scanner.nextInt();
        if(fasadRoom.findById(id)==null){
            System.out.println("room not found \n");
        }else
        System.out.println(fasadRoom.findById(id));
    }
}
