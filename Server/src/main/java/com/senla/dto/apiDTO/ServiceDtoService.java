package com.senla.dto.apiDTO;

import com.senla.dto.modelDTO.ServiceDTO;

import java.util.List;

public interface ServiceDtoService {

    public ServiceDTO getById(Integer id);

    public List getAll();

    public void save(ServiceDTO serviceDTO);

    public void update(ServiceDTO serviceDTO);

    public void delete(Integer id);

    void update(Integer id, ServiceDTO serviceDTO);
}
