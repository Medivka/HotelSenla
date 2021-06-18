package com.senla.webControllers;


import com.senla.User;

import com.senla.UserDao;
import com.senla.dto.apiDTO.UserDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserDao userDaoImpl;
    @Autowired
    UserDtoService userDtoService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @GetMapping("/login")
    public String findAll(Model model) {
        List<UserDTO> clientList = userDtoService.getAll();
        model.addAttribute("userDTO", clientList);
        return "login";
    }


    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm) {
         userDaoImpl.save(userForm);
         return "redirect:/index";
    }

}
