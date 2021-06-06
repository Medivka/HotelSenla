package com.senla.dto.dtoService;

import com.senla.api.fasad.IFasadRoom;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.apiDTO.RoomDtoService;
import com.senla.dto.modelDTO.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomDtoServiceImpl implements RoomDtoService {

    private IFasadRoom fasadRoom;
    private MappingDTO mappingDTOImpl;

    public RoomDtoServiceImpl(IFasadRoom fasadRoom, MappingDTO mappingDTOImpl) {
        this.fasadRoom = fasadRoom;
        this.mappingDTOImpl = mappingDTOImpl;
    }

    @Override
    public List getAll() {
        return fasadRoom.showAllRoom().stream().map(mappingDTOImpl::mapRoomToRoomDTO).collect(Collectors.toList());
    }

    @Override
    public RoomDTO getById(Integer id) {
        return mappingDTOImpl.mapRoomToRoomDTO(fasadRoom.findById(id));
    }

    @Override
    public void save(RoomDTO roomDTO) {
        fasadRoom.save(mappingDTOImpl.mapRoomDtoToRoom(roomDTO));
    }

    @Override
    public void delete(Integer id) {
        fasadRoom.deleteRoom(fasadRoom.findById(id));
    }

    @Override
    public void update(RoomDTO roomDTO) {
        fasadRoom.updateRoom(mappingDTOImpl.mapRoomDtoToRoom(roomDTO));
    }
}
