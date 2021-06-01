package com.senla.actions.service;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.logging.Level;

public class ShowAllService extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadService.showAllService().forEach(System.out::println);
            LOGGER.log(Level.INFO, "ShowAllService");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ShowAllService failed");
            System.err.println("ShowAllService failed");
        }
    }
}