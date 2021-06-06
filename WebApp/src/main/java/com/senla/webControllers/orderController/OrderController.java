package com.senla.webControllers.orderController;

import com.senla.api.fasad.IFasadOrder;
import com.senla.dao.OrderDao;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/web")
public class OrderController {

MappingDTO mappingDTO;
    IFasadOrder fasadOrder;

    @Autowired
    public OrderController(MappingDTO mappingDTO, IFasadOrder fasadOrder) {
        this.mappingDTO = mappingDTO;
        this.fasadOrder = fasadOrder;
    }




    @GetMapping("/orders")
    public String findAll(Model model){
        List<Order> orders = fasadOrder.showAllOrder();

        model.addAttribute("orders",orders);
        return "/orders-list";
    }


}
