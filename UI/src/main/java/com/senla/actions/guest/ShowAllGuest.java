package com.senla.actions.guest;

import com.senla.exceptions.ServiceExeption;
import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;


import java.util.logging.Level;

public class ShowAllGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            LOGGER.log(Level.INFO, "ShowAllGuest");
            fasadGuest.showAllGuests().forEach(System.out::println);
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllGuest");
            System.err.println("ShowAllGuest failed");
        }
    }
}
