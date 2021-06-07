package com.senla.webControllers.orderController;

import com.senla.api.fasad.IFasadOrder;
import com.senla.dao.OrderDao;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.apiDTO.OrderDtoService;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/web")
public class OrderController {


    private OrderDtoService orderDtoServiceImpl;


    public OrderController(OrderDtoService orderDtoServiceImpl) {
        this.orderDtoServiceImpl = orderDtoServiceImpl;
    }


    @GetMapping("/orders")
    public String findAll(Model model){
        List<OrderDTO> ordersDto = orderDtoServiceImpl.getAll();
       model.addAttribute("ordersDto",ordersDto);
        return "/orders-list";
    }

    @GetMapping("order-delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id){
        orderDtoServiceImpl.delete(id);

        return "redirect:/web/orders";
    }


}
