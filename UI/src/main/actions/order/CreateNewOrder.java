package main.actions.order;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.senla.exceptions.ServiceExeption;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;

public class CreateNewOrder extends AbstractFasad implements IAction {
    LocalDate localDate = LocalDate.now();

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Id guest: ");
            Integer guestId = scanner.nextInt();
            System.out.print("Enter Room Id: ");
            Integer roomId = scanner.nextInt();
            System.out.print("Enter Service Id: ");
            Integer serviceId = scanner.nextInt();
            System.out.print("Enter days of Stay: ");
            Integer daysOfStay = scanner.nextInt();
            System.out.println(fasadOrder.createNewOrder(fasadGuest.findById(guestId)
                    , fasadRoom.findById(roomId)
                    , fasadService.findById(serviceId)
                    , localDate
                    , daysOfStay
            ) + "\n");
            LOGGER.log(Level.INFO, String.format("CreateNewOrder guest: %s roomID: %s serviceID: %s days: %s", guestId, roomId, serviceId, daysOfStay));
        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "CreateNewOrder failed");
            System.err.println("CreateNewOrder failed");
        }
    }
}
