package com.vtest.it.springclouduserservice.dao.auth;

import common.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {
    public void addNewRole(@Param("roleName") String roleName, @Param("description") String description);

    public void removeRole(@Param("roleName") String roleName);

    public Role getRole(@Param("roleName") String roleName);

    public List<Role> getAllRolesByUserId(@Param("id") Integer id);

    public List<Role> getAllRoles();
}
