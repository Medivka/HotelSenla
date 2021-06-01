package com.restControllers;

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

    private  IFasadGuest fasadGuest;
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
    public void delete(@PathVariable int id) {
        fasadGuest.deleteGuest(fasadGuest.findById(id));


    }

    @GetMapping(value = "/all")
    public List<GuestDTO> readAll() {
        final List<GuestDTO> guests = fasadGuest.showAllGuests().stream().map(mappingDTO::mapGuestToGuestDTO).collect(Collectors.toList());
        return guests;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody GuestDTO guestDTO){

    }


}
