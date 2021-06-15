package com.senla;

import java.util.List;

public interface UserRepository {


    public User getUserByUsername( String username);

    List<User> getUserList();

    User getUserByName(String name);
}