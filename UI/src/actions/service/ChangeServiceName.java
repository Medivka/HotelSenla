package actions.service;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class ChangeServiceName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id service: ");
        Integer id = scanner.nextInt();
        if(fasadService.findByID(id)==null){
            System.out.println("Service not found \n");
        }else {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            fasadService.changeServiceName(id, name);
            System.out.println(fasadService.findByID(id));
        }
    }
}