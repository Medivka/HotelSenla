package actions.service;

import actions.AbstractFasad;
import actions.IAction;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class CreateNewService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name service: ");
        String name = scanner.nextLine();
        System.out.println("Enter price service: ");
        Integer price = scanner.nextInt();
        System.out.println(fasadService.createNewService(name, price));

    }
}
