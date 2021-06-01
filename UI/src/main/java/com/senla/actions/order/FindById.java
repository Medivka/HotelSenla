package com.senla.actions.order;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter ID order");
            Integer id = scanner.nextInt();
            if (fasadOrder.findByID(id) == null) {
                System.out.println("Order not found  \n");
            } else {
                LOGGER.log(Level.INFO, String.format("FindById : %s", id));
                System.out.println(fasadOrder.findByID(id));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "FindById failed");
            System.err.println("FindById failed");
        }
    }
}
