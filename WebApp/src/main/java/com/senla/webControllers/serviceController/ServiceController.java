package com.senla.webControllers.serviceController;

import com.senla.dto.apiDTO.RoomDtoService;
import com.senla.dto.apiDTO.ServiceDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("web")
public class ServiceController {
    private ServiceDtoService serviceDtoServiceImpl;
    public ServiceController(ServiceDtoService serviceDtoServiceImpl) {
        this.serviceDtoServiceImpl = serviceDtoServiceImpl;
    }
    @GetMapping("/services")
    public String findAll(Model model){
        List<ServiceDTO> servicesDTO=serviceDtoServiceImpl.getAll();
        model.addAttribute("servicesDTO",servicesDTO);
        return "services-list";
    }
    @GetMapping("/service-update/{id}")
    public String updateServiceDTO(@PathVariable("id") Integer id, Model model){
        ServiceDTO serviceDTO=serviceDtoServiceImpl.getById(id);
        model.addAttribute("serviceDTO",serviceDTO);

        return "/service-update";
    }
    @PostMapping("/service-update")
    public String updatePlayer(ServiceDTO serviceDTO){
          serviceDtoServiceImpl.update( serviceDTO);
        return "redirect:/web/services";
    }

    @GetMapping("service-delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id){
          serviceDtoServiceImpl.delete(id);

        return "redirect:/web/services";
    }
}
