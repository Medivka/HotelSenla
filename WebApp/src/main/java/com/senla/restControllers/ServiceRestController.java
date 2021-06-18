package com.senla.restControllers;


import com.senla.dto.apiDTO.ServiceDtoService;
import com.senla.dto.modelDTO.ServiceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service")
public class ServiceRestController {


    private ServiceDtoService serviceDtoServiceImpl;

    public ServiceRestController(ServiceDtoService serviceDtoServiceImpl) {
        this.serviceDtoServiceImpl = serviceDtoServiceImpl;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ServiceDTO> read(@PathVariable(name = "id") int id) {
        final ServiceDTO serviceDTO = serviceDtoServiceImpl.getById(id);


        return serviceDTO != null
                ? new ResponseEntity<>(serviceDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        final List<ServiceDTO> serviceDTOList = serviceDtoServiceImpl.getAll();
        for (ServiceDTO serviceDTO : serviceDTOList) {
            if (serviceDTO.getId().equals(id)) {
                delete = true;
                serviceDtoServiceImpl.delete(id);
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ServiceDTO>> read() {
        final List<ServiceDTO> serviceDTOList = serviceDtoServiceImpl.getAll();
        return serviceDTOList != null && !serviceDTOList.isEmpty()
                ? new ResponseEntity<>(serviceDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody ServiceDTO serviceDTO) {
        serviceDtoServiceImpl.save(serviceDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ServiceDTO serviceDTO) {
        boolean update = false;
        final List<ServiceDTO> serviceDTOList = serviceDtoServiceImpl.getAll();
        for (ServiceDTO service : serviceDTOList) {
            if (service.getId().equals(id)) {
                update = true;
                serviceDtoServiceImpl.update(serviceDTO);
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
