package com.senla.restControllers;

import com.senla.dto.dtoService.OrderDtoServiceImpl;
import com.senla.dto.modelDTO.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderRestController {

    private OrderDtoServiceImpl orderDtoServiceImpl;

    public OrderRestController(OrderDtoServiceImpl orderDtoServiceImpl) {
        this.orderDtoServiceImpl = orderDtoServiceImpl;
    }


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<OrderDTO> read(@PathVariable(name = "id") int id) {
        final OrderDTO orderDTO = orderDtoServiceImpl.getById(id);
        return orderDTO != null
                ? new ResponseEntity<>(orderDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO) {
        orderDtoServiceImpl.save(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<OrderDTO>> read() {
        List<OrderDTO> orderDTOList = orderDtoServiceImpl.getAll();
        return orderDTOList != null && !orderDTOList.isEmpty()
                ? new ResponseEntity<>(orderDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody OrderDTO orderDTO) {
        boolean update = false;
        List<OrderDTO> orderDTOList = orderDtoServiceImpl.getAll();
        for (OrderDTO order : orderDTOList) {
            if (order.getId().equals(id)) {
                update = true;
                orderDtoServiceImpl.update(orderDTO);
            }
        }
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean delete = false;
        List<OrderDTO> orderDTOList = orderDtoServiceImpl.getAll();
        for (OrderDTO orderDTO : orderDTOList) {
            if (orderDTO.getId().equals(id)) {
                orderDtoServiceImpl.delete(id);
                delete = true;
            }
        }
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}