package com.senla.actions.guest;

import com.senla.exceptions.ServiceExeption;
import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;


import java.util.logging.Level;

public class SortedByAge extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "SortedByAge ");
            fasadGuest.sortedByAge().forEach(System.out::println);
        } catch (ServiceExeption exeption) {
            LOGGER.log(Level.INFO, "SortedByAge failed ");
            System.err.println("SortedByAge failed");
        }
    }
}

