package com.senla.dto.dtoService;

import com.senla.api.fasad.IFasadGuest;
import com.senla.dto.apiDTO.GuestDtoService;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.modelDTO.GuestDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestDtoServiceImpl implements GuestDtoService {

    private IFasadGuest fasadGuest;
    private MappingDTO mappingDTOImpl;

    public GuestDtoServiceImpl(IFasadGuest fasadGuest, MappingDTO mappingDTOImpl) {
        this.fasadGuest = fasadGuest;
        this.mappingDTOImpl = mappingDTOImpl;
    }


    @Override
    public List getAll() {
        return fasadGuest.showAllGuests().stream().map(mappingDTOImpl::mapGuestToGuestDTO).collect(Collectors.toList());

    }

    @Override
    public GuestDTO getById(Integer id) {
        return mappingDTOImpl.mapGuestToGuestDTO(fasadGuest.findById(id));
    }

    @Override
    public void delete(Integer id) {
        fasadGuest.deleteGuest(id);

    }

    @Override
    public void update(GuestDTO guestDTO) {
        fasadGuest.updateGuest(mappingDTOImpl.mapGuestDtoTOGuest(guestDTO));

    }

    @Override
    public void save(GuestDTO guestDTO) {
        fasadGuest.saveGuest(mappingDTOImpl.mapGuestDtoTOGuest(guestDTO));

    }

    @Override
    public void update(Integer guestNumber, GuestDTO guestDTO) {
        fasadGuest.updateGuest(guestNumber, mappingDTOImpl.mapGuestDtoTOGuest(guestDTO));
    }
}
