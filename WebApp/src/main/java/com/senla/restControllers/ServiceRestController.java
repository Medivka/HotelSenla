package com.senla.restControllers;

import com.senla.api.fasad.IFasadService;

import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import com.senla.fasad.FasadService;
import com.senla.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class ServiceRestController {

    private IFasadService fasadService;
    private MappingDTO mappingDTOImpl;

    @Autowired
    public ServiceRestController(FasadService fasadService, MappingDTOImpl mappingDTOImpl) {
        this.fasadService = fasadService;
        this.mappingDTOImpl = mappingDTOImpl;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ServiceDTO> read(@PathVariable(name = "id") int id) {
        final ServiceDTO serviceDTO = mappingDTOImpl.mapServiceToServiceDTO(fasadService.findById(id));


        return serviceDTO != null
                ? new ResponseEntity<>(serviceDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        final List<ServiceDTO> serviceDTOList = fasadService.showAllService().stream().map(mappingDTOImpl::mapServiceToServiceDTO).collect(Collectors.toList());
        for (ServiceDTO serviceDTO : serviceDTOList) {
            if (serviceDTO.getId().equals(id)) {
                delete = true;
                fasadService.deleteService(fasadService.findById(id));
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ServiceDTO>> read() {
        final List<ServiceDTO> serviceDTOList = fasadService.showAllService().stream().map(mappingDTOImpl::mapServiceToServiceDTO).collect(Collectors.toList());

        return serviceDTOList != null && !serviceDTOList.isEmpty()
                ? new ResponseEntity<>(serviceDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody ServiceDTO serviceDTO) {
        fasadService.save(mappingDTOImpl.mapServiceDtoToService(serviceDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ServiceDTO serviceDTO) {
        boolean update = false;
        final List<ServiceDTO> serviceDTOList = fasadService.showAllService().stream().map(mappingDTOImpl::mapServiceToServiceDTO).collect(Collectors.toList());
        for (ServiceDTO service : serviceDTOList) {
            if (service.getId().equals(id)) {
                update = true;
                fasadService.updateService(fasadService.findById(id));
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
