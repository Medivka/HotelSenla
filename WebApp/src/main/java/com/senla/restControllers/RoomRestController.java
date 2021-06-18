package com.senla.restControllers;



import com.senla.dto.apiDTO.RoomDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/room")
public class RoomRestController {

    private final RoomDtoService roomDtoServiceImpl;

    public RoomRestController(RoomDtoService roomDtoServiceImpl) {
        this.roomDtoServiceImpl = roomDtoServiceImpl;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<RoomDTO> read(@PathVariable(name = "id") int id) {
        final RoomDTO roomDTO = roomDtoServiceImpl.getById(id);
        return roomDTO != null
                ? new ResponseEntity<>(roomDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        final List<RoomDTO> roomDTOList = roomDtoServiceImpl.getAll();
        for (RoomDTO roomDTO : roomDTOList) {
            if (roomDTO.getId().equals(id)) {
                delete = true;
                roomDtoServiceImpl.delete(id);
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/get/all")
    public ResponseEntity<List<RoomDTO>> read() {
        final List<RoomDTO> rooms = roomDtoServiceImpl.getAll();
        return rooms != null && !rooms.isEmpty()
                ? new ResponseEntity<>(rooms, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody RoomDTO roomDTO) {
        roomDtoServiceImpl.save(roomDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody RoomDTO roomDTO) {
        boolean update = false;
        final List<RoomDTO> roomDTOList = roomDtoServiceImpl.getAll();
        for (RoomDTO room : roomDTOList) {
            if (room.getId().equals(id)) {
                update = true;
                roomDtoServiceImpl.update(roomDTO);
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
