package com.senla.actions.room;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.logging.Level;


public class ShowAllRoom extends AbstractFasad implements IAction {

    @Override
    public void execute() {

        try {
            fasadRoom.showAllRoom().forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllRoom");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllRoom failed");
            System.err.println("ShowAllRoom failed");
        }
    }
}
