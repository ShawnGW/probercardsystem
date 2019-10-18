package com.vtest.it.springclouduserservice.service.auth;

import common.domain.Role;
import common.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthService {
    public void addNewRole(String roleName, String description);

    public void removeRole(String roleName);

    public Role getRole(String roleName);

    public List<Role> getAllRolesByUserId(Integer id);

    public List<Role> getAllRoles();

    public User getUser(String username);

    public List<User> getAllUser();

    public void removeUser(String username);

    public void updateUser(User userAdd);
}
