package actions.service;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeServiceName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id service: ");
        Integer id=scanner.nextInt();
        System.out.println("Enter new name: ");
        String name=scanner.nextLine();
        fasadService.findByID(id).setName(name);

    }
}