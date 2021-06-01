package com.senla.actions.guest;

import com.senla.exceptions.ServiceExeption;
import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;


import java.util.logging.Level;

public class SortedById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "SortedById");
            fasadGuest.sortedById().forEach(System.out::println);
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "SortedById");
            System.err.println("SortedById failed");
        }
    }
}
