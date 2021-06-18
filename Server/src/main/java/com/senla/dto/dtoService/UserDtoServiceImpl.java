package com.senla.dto.dtoService;

import com.senla.User;
import com.senla.UserDao;
import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.apiDTO.UserDtoService;
import com.senla.dto.modelDTO.UserDTO;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class UserDtoServiceImpl implements UserDtoService {

    private UserDao userDaoImpl;
    private MappingDTO mappingDTOImpl;

    public UserDtoServiceImpl(UserDao userDaoImpl, MappingDTO mappingDTOImpl) {
        this.userDaoImpl = userDaoImpl;
        this.mappingDTOImpl = mappingDTOImpl;
    }


    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDaoImpl.getAllClients();
        List<UserDTO> userDTOList = new LinkedList<>();
        for (User user : users) {
            userDTOList.add(mappingDTOImpl.mapUserToUserDTO(user));
        }
        return userDTOList;
    }




}
