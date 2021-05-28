import com.JacsonConverter.JacsonConverter;
import com.dto.modelDTO.GuestDTO;
import com.dto.modelDTO.OrderDTO;
import com.fasad.FasadGuest;
import com.model.Guest;
import com.model.Order;
import com.springConfig.JavaConfig;
import com.springConfig.SpringBeans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;


public class MainProgramm {

    public static void main(String[] args) {


        Guest guest=new Guest();
        guest.setAge(23);
        guest.setName("Vitia");
        Order order= new Order();
        order.setLocalDate(LocalDate.now());


        JacsonConverter jacsonConverter= new JacsonConverter();
        String a=jacsonConverter.objectToJson(guest);
        System.out.println(jacsonConverter.objectToJson(order));

        System.out.println(jacsonConverter.JsonToObject(a,Guest.class));

    }
}

