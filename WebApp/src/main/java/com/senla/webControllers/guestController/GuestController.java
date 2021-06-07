package com.senla.webControllers.guestController;

import com.senla.dto.apiDTO.GuestDtoService;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.dto.modelDTO.OrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("web")
public class GuestController {

    private GuestDtoService guestDtoService;

    public GuestController(GuestDtoService guestDtoService) {
        this.guestDtoService = guestDtoService;
    }

    @GetMapping("/guest-all")
    public String findAll(Model model){
        List<GuestDTO> guestDTOList = guestDtoService.getAll();
        model.addAttribute("guestDTOList",guestDTOList);
        return "guests-list";
    }
    @GetMapping("guest-delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id){
        guestDtoService.delete(id);

        return "redirect:/web/guest-all";
    }
}
