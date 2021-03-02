package actions.service;

import actions.AbstractFasad;
import actions.IAction;
import exceptions.ServiceExeption;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.util.logging.Level;

public class CreateNewService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name service: ");
            String name = scanner.next();
            System.out.print("Enter price service: ");
            Integer price = scanner.nextInt();
            System.out.println(fasadService.createNewService(name, price) + "\n");
            LOGGER.log(Level.INFO, String.format("CreateNewService name:%s  price:%s"));

        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "CreateNewService failed");
            System.err.println("CreateNewService failed");
        }
    }
}
