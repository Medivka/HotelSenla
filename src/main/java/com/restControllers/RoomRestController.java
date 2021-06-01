package com.restControllers;




import com.senla.api.fasad.IFasadRoom;
import com.senla.dto.mappingDTO.MappingDTO;
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
    private MappingDTO mappingDTO;

    public RoomRestController(FasadRoom fasadRoom, MappingDTO mappingDTO) {
        this.fasadRoom = fasadRoom;
        this.mappingDTO = mappingDTO;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public RoomDTO getRoom(@PathVariable int id) {
        return mappingDTO.mapRoomToRoomDTO(fasadRoom.findById(id));
    }

    @GetMapping(value = "/all")
    public List<RoomDTO> readAll() {
        final List<RoomDTO> rooms = fasadRoom.showAllRoom().stream().map(mappingDTO::mapRoomToRoomDTO).collect(Collectors.toList());
        return rooms ;
    }

}
