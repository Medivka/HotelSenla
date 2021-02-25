package actions.history;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class GetAllHistory extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        fasadHistory.getAllHistory().forEach(System.out::println);

    }
}
