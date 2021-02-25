package actions.room;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class SortedByPrice extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadRoom.sortedByPrice().forEach(System.out::println);
    }
}