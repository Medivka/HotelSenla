package com.senla.restControllers;

import com.senla.api.fasad.IFasadGuest;
import com.senla.dto.mappingDTO.MappingDTO;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.fasad.FasadGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("guest")
public class GuestRestController {

    private IFasadGuest fasadGuest;
    private MappingDTO mappingDTO;

    @Autowired
    public GuestRestController(FasadGuest fasadGuest, MappingDTO mappingDTO) {
        this.fasadGuest = fasadGuest;
        this.mappingDTO = mappingDTO;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public GuestDTO getGuest(@PathVariable int id) {
        return mappingDTO.mapGuestToGuestDTO(fasadGuest.findById(id));
    }


    @DeleteMapping(value = "/delete/{id}")
    public String  delete(@PathVariable int id) {
        fasadGuest.deleteGuest(fasadGuest.findById(id));
        return "delete";


    }

    @GetMapping(value = "/all")
    public List<GuestDTO> readAll() {
        return fasadGuest.showAllGuests().stream().map(mappingDTO::mapGuestToGuestDTO).collect(Collectors.toList());

    }

    @PostMapping(value = "/save")
    public void save(@RequestBody GuestDTO guestDTO) {
        fasadGuest.saveGuest(mappingDTO.mapGuestDtoTOGuest(guestDTO));
    }

    @PutMapping(value = "/update/{id}")
    public GuestDTO update(@RequestBody GuestDTO guestDTO) {
        fasadGuest.updateGuest(mappingDTO.mapGuestDtoTOGuest(guestDTO));
        return guestDTO;
    }

}
