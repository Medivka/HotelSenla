package com.senla.actions.room;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.logging.Level;

public class SortedByPrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadRoom.sortedByPrice().forEach(System.out::println);
            LOGGER.log(Level.INFO, "SortedByPrice");

        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "SortedByPrice failed");
            System.err.println("SortedByPrice failed");
        }
    }
}