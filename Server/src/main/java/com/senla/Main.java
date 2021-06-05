package com.senla;

import com.senla.dao.RoomDao;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.fasad.FasadRoom;
import com.senla.model.Guest;

public class Main {
    public static void main(String[] args) {
        MappingDTOImpl mappingDTO= new MappingDTOImpl();
        System.out.println("sdas");
        Guest guest= new Guest();
        guest.setName("sadsa");
        guest.setLastName("asdasdf");
        GuestDTO guestDTO= mappingDTO.mapGuestToGuestDTO(guest);
        System.out.println(guestDTO);
    }
}
