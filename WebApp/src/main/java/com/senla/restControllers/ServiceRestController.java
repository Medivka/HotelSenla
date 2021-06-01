package com.senla.restControllers;

import com.senla.api.fasad.IFasadService;
import com.senla.fasad.FasadService;
import com.senla.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceRestController {

   private IFasadService fasadService;

    @Autowired
    public ServiceRestController(FasadService fasadService) {
        this.fasadService = fasadService;
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Service getService(@PathVariable int id) {
        return fasadService.findById(id);
    }
}

