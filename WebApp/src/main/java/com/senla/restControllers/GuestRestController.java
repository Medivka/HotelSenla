package com.senla.restControllers;

import com.senla.api.fasad.IFasadGuest;
import com.senla.dto.apiDTO.GuestDtoService;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.fasad.FasadGuest;
import com.senla.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("guest")
public class GuestRestController {

    private GuestDtoService guestDtoServiceIml;

    public GuestRestController(GuestDtoService guestDtoServiceIml) {
        this.guestDtoServiceIml = guestDtoServiceIml;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<GuestDTO> read(@PathVariable(name = "id") int id) {
        final GuestDTO GuestDTO = guestDtoServiceIml.getById(id);
        return GuestDTO != null
                ? new ResponseEntity<>(GuestDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        final List<GuestDTO> guestDTOList = guestDtoServiceIml.getAll();
        for (GuestDTO guest : guestDTOList) {
            if (guest.getGuestNumber().equals(id)) {
                delete = true;
                guestDtoServiceIml.delete(id);
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/get/all")
    public ResponseEntity<List<GuestDTO>> read() {
        final List<GuestDTO> clients = guestDtoServiceIml.getAll();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody GuestDTO guestDTO) {
        guestDtoServiceIml.save(guestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody GuestDTO guestDTO) {
        boolean update = false;
        final List<GuestDTO> guestDTOList = guestDtoServiceIml.getAll();
        for (GuestDTO guest : guestDTOList) {
            if (guest.getGuestNumber().equals(id)) {
                update = true;
                guestDtoServiceIml.update(guestDTO);
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
