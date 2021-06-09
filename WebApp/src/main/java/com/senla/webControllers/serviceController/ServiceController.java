package com.senla.webControllers.serviceController;

import com.senla.dto.apiDTO.RoomDtoService;
import com.senla.dto.apiDTO.ServiceDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("web/service")
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
    public String updateServiceDTO(ServiceDTO serviceDTO){
          serviceDtoServiceImpl.update(serviceDTO.getId(), serviceDTO);
        return "redirect:/web/service/services";
    }

    @GetMapping("service-delete/{id}")
    public String deleteService(@PathVariable("id") Integer id){
          serviceDtoServiceImpl.delete(id);
        return "redirect:/web/service/services";
    }

    @GetMapping("/service-new")
    public String createServiceForm(Model model){
     model.addAttribute("serviceDTO", new ServiceDTO());
        return "service-new";
    }
    @RequestMapping( method = { RequestMethod.GET, RequestMethod.POST })
    @PostMapping("/service-create")
    public String createService(@ModelAttribute("serviceDTO") ServiceDTO serviceDTO){
       serviceDtoServiceImpl.save(serviceDTO);
        return "redirect:/web/service/services";
    }

}
