package com.senla.webControllers.RoomController;

import com.senla.dto.apiDTO.RoomDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("web")
public class RoomController {
private RoomDtoService roomDtoServiceImpl;

    public RoomController(RoomDtoService roomDtoServiceImpl) {
        this.roomDtoServiceImpl = roomDtoServiceImpl;
    }
    @GetMapping("/rooms")
    public String findAll(Model model){
       List<RoomDTO> roomsDTO=roomDtoServiceImpl.getAll();
        model.addAttribute("roomsDTO",roomsDTO);
        return "rooms-list";
    }
    @GetMapping("room-delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id){
        roomDtoServiceImpl.delete(id);
        return "redirect:/web/rooms";
    }

}
