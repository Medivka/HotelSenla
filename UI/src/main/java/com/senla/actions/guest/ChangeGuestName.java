package com.senla.actions.guest;

import com.senla.exceptions.ServiceExeption;
import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;


import java.util.Scanner;
import java.util.logging.Level;

public class ChangeGuestName extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter guest id: ");
            Integer id = scanner.nextInt();
            if (fasadGuest.findById(id) == null) {
                System.out.println("Guest not found  \n");
            } else {
                System.out.print("Enter new Name Guest: ");
                String name = scanner.next();
                fasadGuest.changeName(id, name);
                System.out.println(fasadGuest.findById(id));
                LOGGER.log(Level.INFO, String.format("ChangeGuestName id: %s  name: %s", id, name));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "ChangeGuestName failed");
            System.err.println("ChangeGuestName failed");
        }
    }
}
