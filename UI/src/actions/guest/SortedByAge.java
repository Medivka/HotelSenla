package actions.guest;

import actions.AbstractFasad;
import actions.IAction;

import java.util.Scanner;

public class SortedByAge extends AbstractFasad implements IAction {
    @Override
    public void execute() {
       fasadGuest.sortedByAge().forEach(System.out::println);
}}

