package com.senla.webControllers.orderController;


import com.senla.dto.apiDTO.OrderDtoService;
import com.senla.dto.modelDTO.OrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/order")
public class OrderController {


    private final OrderDtoService orderDtoServiceImpl;


    public OrderController(OrderDtoService orderDtoServiceImpl) {
        this.orderDtoServiceImpl = orderDtoServiceImpl;
    }


    @GetMapping("/orders")
    public String findAll(Model model) {
        List<OrderDTO> ordersDto = orderDtoServiceImpl.getAll();
        model.addAttribute("ordersDto", ordersDto);
        return "/orders-list";
    }

    @GetMapping("order-delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id) {
        orderDtoServiceImpl.delete(id);

        return "redirect:/web/order/orders";
    }

    @GetMapping("/order-update/{id}")
    public String updateServiceDTO(@PathVariable("id") Integer id, Model model) {
        OrderDTO orderDTO = orderDtoServiceImpl.getById(id);
        model.addAttribute("orderDTO", orderDTO);

        return "/order-update";
    }

    @PostMapping("/order-update")
    public String updateOrderDTO(OrderDTO orderDTO) {
        orderDtoServiceImpl.update(orderDTO.getId(), orderDTO);
        return "redirect:/web/order/orders";
    }


}
