package com.senla.dto.apiDTO;

import com.senla.api.enums.RoomStatus;
import com.senla.dto.modelDTO.RoomDTO;

import java.util.List;

public interface RoomDtoService {

    public List getAll();

    public RoomDTO getById(Integer id);

    public void save(RoomDTO roomDTO);

    public void delete(Integer id);

    public void update(RoomDTO roomDTO);

    public void update(Integer id, RoomDTO roomDTO);
}
