package com.senla.actions.service;

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
            System.out.print("Enter id com.service: ");
            Integer id = scanner.nextInt();
            if (fasadService.findById(id) == null) {
                System.out.println("Service not found \n");
            } else {
                System.out.println(fasadService.findById(id));
                LOGGER.log(Level.INFO, String.format("FindById : %s", id));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "FindById failed");
            System.err.println("FindById failed");
        }
    }
}