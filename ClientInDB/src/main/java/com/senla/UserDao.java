package com.senla;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface UserDao {

    User findByUserName(String username);
    void delete(User user);
    void save(User user);

    List getAllClients();
}
