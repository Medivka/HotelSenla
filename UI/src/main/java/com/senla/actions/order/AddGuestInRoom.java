package com.senla.actions.order;

import com.senla.exceptions.ServiceExeption;
import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;


import java.util.Scanner;
import java.util.logging.Level;

public class AddGuestInRoom extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter OrderNumber: ");
            Integer orderNumber = scanner.nextInt();
            if (fasadOrder.findByID(orderNumber) == null) {
                System.out.println("Order not found \n");
            } else {
                System.out.print("Enter GuestID: ");
                Integer guestNumber = scanner.nextInt();
                fasadOrder.addGuestInRoom(orderNumber, fasadGuest.findById(guestNumber));
                System.out.println(fasadOrder.findByID(orderNumber));
                LOGGER.log(Level.INFO, String.format("AddGuestInRoom  order: %s  Guest: %s", orderNumber, guestNumber));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "AddGuestInRoom failed");
            System.err.println("AddGuestInRoom failed");
        }
    }
}
