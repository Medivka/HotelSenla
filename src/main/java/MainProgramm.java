import com.dto.GuestDTO;
import com.mappingDTO.MappingDTO;
import com.springConfig.SpringBeans;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;


public class MainProgramm {

    public static void main(String[] args) {


        SpringBeans.init();
        GuestDTO guestDTO = SpringBeans.mappingDTO.mapGuestToGuestDTO(SpringBeans.fasadGuest.findById(2));
        System.out.println(guestDTO);
        System.out.println(SpringBeans.mappingDTO.mapGuestDtoTOGuest(guestDTO));

    }}

