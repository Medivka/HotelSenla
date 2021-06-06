package com.senla.dto.dtoService;

import com.senla.api.fasad.IFasadService;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.apiDTO.ServiceDtoService;
import com.senla.dto.modelDTO.ServiceDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ServiceDtoServiceImpl implements ServiceDtoService {

    private IFasadService fasadService;
    private MappingDTO mappingDTOImpl;

    public ServiceDtoServiceImpl(IFasadService fasadService, MappingDTO mappingDTOImpl) {
        this.fasadService = fasadService;
        this.mappingDTOImpl = mappingDTOImpl;
    }
    @Override
    public ServiceDTO getById(Integer id) {
        return mappingDTOImpl.mapServiceToServiceDTO(fasadService.findById(id));
    }

    @Override
    public List getAll() {
        return  fasadService.showAllService().stream().map(mappingDTOImpl::mapServiceToServiceDTO).collect(Collectors.toList());


    }

    @Override
    public void save(ServiceDTO serviceDTO) {
        fasadService.save(mappingDTOImpl.mapServiceDtoToService(serviceDTO));

    }

    @Override
    public void update(ServiceDTO serviceDTO) {
        fasadService.save(mappingDTOImpl.mapServiceDtoToService(serviceDTO));

    }

    @Override
    public void delete(Integer id) {
        fasadService.deleteService(fasadService.findById(id));

    }
}
