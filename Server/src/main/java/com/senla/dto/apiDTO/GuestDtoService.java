package com.senla.dto.apiDTO;

import com.senla.dto.modelDTO.GuestDTO;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

public interface GuestDtoService {
    public List getAll();
    public GuestDTO getById(Integer id);
    public void delete (Integer id);
    public void update (GuestDTO guestDTO);
    public void save (GuestDTO guestDTO);

    void update(Integer guestNumber, GuestDTO guestDTO);
}
