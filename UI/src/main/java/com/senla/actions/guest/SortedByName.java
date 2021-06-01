package com.senla.actions.guest;

import com.senla.exceptions.ServiceExeption;
import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;


import java.util.logging.Level;

public class SortedByName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "SortedByName");
            fasadGuest.sortedByName().forEach(System.out::println);
        } catch (ServiceExeption e) {
            LOGGER.log(Level.INFO, "SortedByName failed");
            System.err.println("SortedByName failed");
        }
    }
}