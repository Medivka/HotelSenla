package com.senla;

public interface UserDao {
    User findByUserName(String username);

    void delete(User user);

    void save(User user);
}
