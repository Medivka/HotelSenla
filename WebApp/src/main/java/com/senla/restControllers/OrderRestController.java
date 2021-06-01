package com.senla.restControllers;


import com.senla.api.fasad.IFasadOrder;
import com.senla.dto.mappingDTO.MappingDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.fasad.FasadOrder;
import com.senla.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderRestController {
   private   IFasadOrder fasadOrder;
   private   MappingDTO mappingDTO;

    @Autowired
    public OrderRestController(FasadOrder fasadOrder, MappingDTO mappingDTO) {
        this.fasadOrder = fasadOrder;
        this.mappingDTO = mappingDTO;
    }

    @GetMapping(value = "/{id}",  produces = "application/json")
    public OrderDTO getOrder(@PathVariable int id) {
        return mappingDTO.mapOrderToOrderDTO(fasadOrder.findByID(id));
    }

    @GetMapping(value = "/all")
    public List<Order> getAll() {
        final List<Order> orders = fasadOrder.showAllOrder();
        return orders ;
    }
}
