package com.senla.webControllers.RoomController;

import com.senla.dto.apiDTO.RoomDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("web/room")
public class RoomController {
    private final RoomDtoService roomDtoServiceImpl;

    public RoomController(RoomDtoService roomDtoServiceImpl) {
        this.roomDtoServiceImpl = roomDtoServiceImpl;
    }

    @GetMapping("/rooms")
    public String findAll(Model model) {
        List<RoomDTO> roomsDTO = roomDtoServiceImpl.getAll();
        model.addAttribute("roomsDTO", roomsDTO);
        return "rooms-list";
    }

    @GetMapping("room-delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id) {
        roomDtoServiceImpl.delete(id);
        return "redirect:/web/room/rooms";
    }

    @GetMapping("/room-new")
    public String createRoomForm(Model model) {
        model.addAttribute("roomDTO", new RoomDTO());
        return "room-new";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/room-create")
    public String createRoom(@ModelAttribute("roomDTO") RoomDTO roomDTO) {
        roomDtoServiceImpl.save(roomDTO);
        return "redirect:/web/room/rooms";
    }

    @GetMapping("/room-update/{id}")
    public String updateRoomDTO(@PathVariable("id") Integer id, Model model) {
        RoomDTO roomDTO = roomDtoServiceImpl.getById(id);
        model.addAttribute("roomDTO", roomDTO);

        return "/room-update";
    }

    @PostMapping("/room-update")
    public String updateRoomDTO(RoomDTO roomDTO) {
        roomDtoServiceImpl.update(roomDTO.getId(), roomDTO);
        return "redirect:/web/room/rooms";
    }

}
