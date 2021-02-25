package actions.service;

import actions.AbstractFasad;
import actions.IAction;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id service: ");
        Integer id=scanner.nextInt();
        System.out.println(fasadService.findByID(id));

    }
}