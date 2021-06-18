package com.senla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {

@Autowired
private  UserDao userDaoImpl;

//@Autowired
//RoleDaoImpl roleDao;
//    List<Role> roles=roleDao.getAllRoles();



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User client = userDaoImpl.findByUserName(username);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(), client.getPassword(),
                    client.getRoles());
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }

    public boolean saveUser(User user) {

        User  client = userDaoImpl.findByUserName(user.getUsername());
        if (client != null) {
            return false;
        }
//        user.setRoles(Collections.singleton(roles.get(1)));
        userDaoImpl.save(user);
        return true;
    }
}