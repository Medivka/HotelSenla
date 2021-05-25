import com.dto.GuestDTO;
import com.dto.OrderDTO;
import com.mappingDTO.MappingDTO;
import com.springConfig.SpringBeans;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;


public class MainProgramm {

    public static void main(String[] args) {


        SpringBeans.init();
        OrderDTO orderDTO=SpringBeans.mappingDTO.mapOrderToOrderDTO(SpringBeans.fasadOrder.findByID(2));
        GuestDTO guestDTO = SpringBeans.mappingDTO.mapGuestToGuestDTO(SpringBeans.fasadGuest.findById(2));
        System.out.println(orderDTO);
        System.out.println(SpringBeans.mappingDTO.mapGuestDtoTOGuest(guestDTO));

    }}

