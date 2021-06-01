package com.senla.actions.order;

import com.senla.actions.AbstractFasad;
import com.senla.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class GetAllAmount extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter OrderNumber: ");
            Integer orderNumber = scanner.nextInt();
            if (fasadOrder.findByID(orderNumber) == null) {
                System.out.println("Order not found \n");
            } else {
                System.out.println(fasadOrder.findByID(orderNumber));
                System.out.println("All amount: " + fasadOrder.getAllAmount(orderNumber));
                LOGGER.log(Level.INFO, String.format("GetAllAmount idOrder: %s", orderNumber));
            }
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "GetAllAmount failed");
            System.err.println("GetAllAmount failed");
        }
    }
}
