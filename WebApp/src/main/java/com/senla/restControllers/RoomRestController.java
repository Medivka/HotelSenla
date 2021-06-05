package com.senla.restControllers;


import com.senla.api.fasad.IFasadRoom;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.fasad.FasadRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
public class RoomRestController {

    private IFasadRoom fasadRoom;
    private MappingDTO mappingDTOImpl;

    public RoomRestController(FasadRoom fasadRoom, MappingDTOImpl mappingDTOImpl) {
        this.fasadRoom = fasadRoom;
        this.mappingDTOImpl = mappingDTOImpl;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<RoomDTO> read(@PathVariable(name = "id") int id) {
        final RoomDTO roomDTO = mappingDTOImpl.mapRoomToRoomDTO(fasadRoom.findById(id));


        return roomDTO != null
                ? new ResponseEntity<>(roomDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        final List<RoomDTO> roomDTOList = fasadRoom.showAllRoom().stream().map(mappingDTOImpl::mapRoomToRoomDTO).collect(Collectors.toList());
        for (RoomDTO roomDTO : roomDTOList) {
            if (roomDTO.getId().equals(id)) {
                delete = true;
                fasadRoom.deleteRoom(fasadRoom.findById(id));
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/get/all")
    public ResponseEntity<List<RoomDTO>> read() {
        final List<RoomDTO> rooms = fasadRoom.showAllRoom().stream().map(mappingDTOImpl::mapRoomToRoomDTO).collect(Collectors.toList());

        return rooms != null && !rooms.isEmpty()
                ? new ResponseEntity<>(rooms, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody RoomDTO roomDTO) {
        fasadRoom.save(mappingDTOImpl.mapRoomDtoToRoom(roomDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody RoomDTO roomDTO) {
        boolean update = false;
        final List<RoomDTO> roomDTOList = fasadRoom.showAllRoom().stream().map(mappingDTOImpl::mapRoomToRoomDTO).collect(Collectors.toList());
        for (RoomDTO room : roomDTOList) {
            if (room.getId().equals(id)) {
                update = true;
                fasadRoom.updateRoom(mappingDTOImpl.mapRoomDtoToRoom(roomDTO));
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
