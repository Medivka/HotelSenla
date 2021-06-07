package com.senla.webControllers.guestController;

import com.senla.dto.apiDTO.GuestDtoService;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("web/guest")
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

        return "redirect:/web/guest/guest-all";
    }
    @GetMapping("/guest-new")
    public String createServiceForm(Model model){
        model.addAttribute("guestDTO", new GuestDTO());
        return "guest-new";
    }
    @RequestMapping( method = { RequestMethod.GET, RequestMethod.POST })
    @PostMapping("/guest-create")
    public String createService(@ModelAttribute("guestDTO") GuestDTO guestDTO){
       guestDtoService.save(guestDTO);
        return "redirect:/web/guest/guest-all";
    }
}
