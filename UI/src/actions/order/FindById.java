package actions.order;

import actions.AbstractFasad;
import actions.IAction;
import fasad.FasadOrder;

import java.util.Scanner;

public class FindById extends AbstractFasad implements IAction {
    @Override
    public void execute() {
        Scanner scanner=new  Scanner(System.in);
        System.out.print("Enter ID order");
        Integer id=scanner.nextInt();
        if(fasadOrder.findByID(id)==null){
            System.out.println("Order not found  \n");
        }else
        System.out.println(fasadOrder.findByID(id));

    }
}
