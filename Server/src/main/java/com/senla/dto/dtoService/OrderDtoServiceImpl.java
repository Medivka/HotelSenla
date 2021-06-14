package com.senla.dto.dtoService;

import com.senla.api.fasad.IFasadOrder;

import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.apiDTO.OrderDtoService;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.model.Order;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrderDtoServiceImpl implements OrderDtoService {
    private IFasadOrder fasadOrder;
    private MappingDTO mappingDTO;

    public OrderDtoServiceImpl(IFasadOrder fasadOrder, MappingDTO mappingDTO) {
        this.fasadOrder = fasadOrder;
        this.mappingDTO = mappingDTO;
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> orders = fasadOrder.showAllOrder();
        List<OrderDTO> orderDTOList = new LinkedList<>();
        for (Order order : orders) {
            orderDTOList.add(mappingDTO.mapOrderToOrderDTO(order));
        }
        return orderDTOList;
    }

    @Override
    public OrderDTO getById(Integer id) {
        final OrderDTO orderDTO = mappingDTO.mapOrderToOrderDTO(fasadOrder.findByID(id));
        return orderDTO;
    }

    @Override
    public void delete(Integer id) {
        fasadOrder.deleteOrder(id);
    }

    @Override
    public void update(OrderDTO orderDTO) {
        fasadOrder.updateOrder(mappingDTO.mapOrderDtoToOrder(orderDTO));

    }

    @Override
    public void save(OrderDTO orderDTO) {
        fasadOrder.save(mappingDTO.mapOrderDtoToOrder(orderDTO));
    }

    @Override
    public void update(Integer id, OrderDTO orderDTO) {
        fasadOrder.updateOrder(id,mappingDTO.mapOrderDtoToOrder(orderDTO));
    }

}
