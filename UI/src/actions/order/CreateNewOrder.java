package actions.order;

import actions.AbstractFasad;
import actions.IAction;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateNewOrder extends AbstractFasad implements IAction {
    LocalDate localDate = LocalDate.now();

    @Override
    public void execute() {
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
                , fasadService.findByID(serviceId)
                , localDate
                , daysOfStay
        )+ "\n");

    }
}
