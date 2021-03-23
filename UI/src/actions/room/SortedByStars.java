package actions.room;

import actions.AbstractFasad;
import actions.IAction;
import com.exceptions.ServiceExeption;

import java.util.logging.Level;

public class SortedByStars extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        try {
            fasadRoom.sortedByStars().forEach(System.out::println);
            LOGGER.log(Level.INFO, "SortedByStars");

        } catch (ServiceExeption e) {
            LOGGER.log(Level.WARNING, "SortedByStars failed");
            System.err.println("SortedByStars failed");
        }
    }
}