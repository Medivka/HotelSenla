package com.senla.dto.apiDTO;

import com.senla.dto.modelDTO.OrderDTO;

import java.util.List;

public interface OrderDtoService {

    List<OrderDTO> getAll();

    OrderDTO getById(Integer id);

    void delete(Integer id);

    void update(OrderDTO orderDTO);

    void save(OrderDTO orderDTO);

    void update(Integer id, OrderDTO orderDTO);
}
