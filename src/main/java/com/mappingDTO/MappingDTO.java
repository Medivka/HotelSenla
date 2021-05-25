package com.mappingDTO;

import com.dto.GuestDTO;
import com.dto.RoomDTO;
import com.model.Guest;
import com.model.Room;
import org.springframework.stereotype.Service;

@Service
public class MappingDTO {


    public GuestDTO mapGuestToGuestDTO(Guest guest) {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setGuestNumber(guest.getGuestNumber());
        guestDTO.setName(guest.getName());
        guestDTO.setLastName(guest.getLastName());
        guestDTO.setAge(guest.getAge());
        guestDTO.setPhone(guest.getPhone());
        guestDTO.setGuestGender(guest.getGuestGender());
        guestDTO.setEmail(guest.getEmail());
        guestDTO.setAddress(guest.getAddress());
        return guestDTO;
    }

    public Guest mapGuestDtoTOGuest(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setGuestNumber(guestDTO.getGuestNumber());
        guest.setName(guestDTO.getName());
        guest.setLastName(guestDTO.getLastName());
        guest.setAge(guestDTO.getAge());
        guest.setPhone(guestDTO.getPhone());
        guest.setGuestGender(guestDTO.getGuestGender());
        guest.setEmail(guestDTO.getEmail());
        guest.setAddress(guestDTO.getAddress());
        return guest;
    }
    public RoomDTO mapRoomToRoomDTO(Room room){
        RoomDTO roomDTO=new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomStatus(room.getRoomStatus());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setStars(room.getPrice());

        return roomDTO;
    }
    public Room mapRoomDtoToRoom(RoomDTO roomDTO){
        Room room=new Room();
        room.setId(roomDTO.getId());
        room.setStars(roomDTO.getStars());
        room.setRoomStatus(roomDTO.getRoomStatus());
        room.setCopacity(roomDTO.getCapacity());
        return room;
    }


}
