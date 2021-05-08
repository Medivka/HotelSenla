package main.actions.guest;

import main.actions.AbstractFasad;
import main.actions.IAction;
import com.api.enums.GuestGender;
import com.exceptions.ServiceExeption;

import java.util.Scanner;
import java.util.logging.Level;

public class CreateNewGuest extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            GuestGender guestGender=GuestGender.MALE;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();
            System.out.print("Enter guest lastName: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter guest phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter guest age: ");
            Integer age = scanner.nextInt();
            System.out.println("enter 1 Male 2 female");
            Integer gender =scanner.nextInt();
            if(gender==1)guestGender=GuestGender.MALE;else guestGender=GuestGender.FEMALE;
            System.out.print("Enter guest email: ");
            String email = scanner.nextLine();
            System.out.print("Enter guest address: ");
            String address = scanner.nextLine();
            System.out.println(fasadGuest.createNewGuest(name,lastName, age,phone,guestGender,email,address) + " \n");
            LOGGER.log(Level.INFO, "CreateNewGuest");
        } catch (ServiceExeption e) {
            LOGGER.log(Level.INFO, "CreateNewGuest failed");

            System.err.println("CreateNewGuest failed");
        }
    }
}
