package com.senla.restControllers;




import com.senla.api.fasad.IFasadRoom;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.fasad.FasadRoom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
public class RoomRestController {

    private IFasadRoom fasadRoom;
    private MappingDTOImpl mappingDTOImpl;

    public RoomRestController(FasadRoom fasadRoom, MappingDTOImpl mappingDTOImpl) {
        this.fasadRoom = fasadRoom;
        this.mappingDTOImpl = mappingDTOImpl;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public RoomDTO getRoom(@PathVariable int id) {
        return mappingDTOImpl.mapRoomToRoomDTO(fasadRoom.findById(id));
    }

    @GetMapping(value = "/all")
    public List<RoomDTO> readAll() {
        final List<RoomDTO> rooms = fasadRoom.showAllRoom().stream().map(mappingDTOImpl::mapRoomToRoomDTO).collect(Collectors.toList());
        return rooms ;
    }

}
