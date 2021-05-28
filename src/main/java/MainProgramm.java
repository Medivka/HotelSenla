import com.dto.modelDTO.GuestDTO;
import com.dto.modelDTO.OrderDTO;
import com.fasad.FasadGuest;
import com.springConfig.JavaConfig;
import com.springConfig.SpringBeans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainProgramm {

    public static void main(String[] args) {


        ApplicationContext context= new AnnotationConfigApplicationContext(JavaConfig.class);

        FasadGuest fasadGuest=context.getBean("fasadGuest",FasadGuest.class);
        System.out.println(fasadGuest.findById(2));

    }
}

