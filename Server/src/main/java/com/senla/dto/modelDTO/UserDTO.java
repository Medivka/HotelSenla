package com.senla.dto.modelDTO;

import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String username;
    private String password;


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
