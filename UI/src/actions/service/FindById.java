package actions.service;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.util.logging.Level;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter id service: ");
            Integer id = scanner.nextInt();
            if (fasadService.findByID(id) == null) {
                System.out.println("Service not found \n");
            } else {
                System.out.println(fasadService.findByID(id));
                LOGGER.log(Level.INFO, String.format("FindById : %s", id));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "FindById failed");
            System.err.println("FindById failed");
        }
    }
}