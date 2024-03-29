package com.senla.actions.room;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.logging.Level;

public class ShowAllFreeRoom extends AbstractFasad implements IAction {

    @Override
    public void execute() {
        try {
            fasadRoom.allFreeRoom().forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllFreeRoom");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllFreeRoom failed");
            System.err.println("ShowAllFreeRoom failed");
        }
    }
}