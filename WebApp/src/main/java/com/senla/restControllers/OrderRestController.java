package com.senla.restControllers;


import com.senla.api.fasad.IFasadOrder;

import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.mappingDTO.MappingDTOImpl;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.fasad.FasadOrder;
import com.senla.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    private MappingDTO mappingDTOImpl;
    private IFasadOrder fasadOrder;


    @Autowired
    public OrderRestController(MappingDTOImpl mappingDTOImpl, IFasadOrder fasadOrder) {
        this.mappingDTOImpl = mappingDTOImpl;
        this.fasadOrder = fasadOrder;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<OrderDTO> read(@PathVariable(name = "id") int id) {
        final OrderDTO orderDTO = mappingDTOImpl.mapOrderToOrderDTO(fasadOrder.findByID(id));
        return orderDTO != null
                ? new ResponseEntity<>(orderDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO) {
        fasadOrder.save(mappingDTOImpl.mapOrderDtoToOrder(orderDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<OrderDTO>> read() {
        List<Order> orders = fasadOrder.showAllOrder();
        List<OrderDTO> orderDTOList = new LinkedList<>();
        for (Order order : orders) {
            orderDTOList.add(mappingDTOImpl.mapOrderToOrderDTO(order));
        }

        return orderDTOList != null && !orderDTOList.isEmpty()
                ? new ResponseEntity<>(orderDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody OrderDTO orderDTO) {
        boolean update = false;
        List<Order> orders = fasadOrder.showAllOrder();
        List<OrderDTO> orderDTOList = new LinkedList<>();
        for (Order order : orders) {
            orderDTOList.add(mappingDTOImpl.mapOrderToOrderDTO(order));
        }

        for (OrderDTO order : orderDTOList) {
            if (order.getId().equals(id)) {
                update = true;
                fasadOrder.updateOrder(mappingDTOImpl.mapOrderDtoToOrder(orderDTO));
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        List<Order> orders = fasadOrder.showAllOrder();
        List<OrderDTO> orderDTOList = new LinkedList<>();
        for (Order order : orders) {
            orderDTOList.add(mappingDTOImpl.mapOrderToOrderDTO(order));
        }
        for (OrderDTO orderDTO : orderDTOList) {
            if (orderDTO.getId().equals(id)) {
                delete = true;
                fasadOrder.deleteOrder(fasadOrder.findByID(id));
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}