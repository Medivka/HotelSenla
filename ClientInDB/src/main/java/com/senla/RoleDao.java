package com.senla;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface RoleDao {

   List<Role> getAllRoles();
}
