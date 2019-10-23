package com.vtest.it.springclouduserservice.dao.auth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleGrantDao {
    public void grant(@Param("userId") Integer userId, @Param("list") List<Integer> roles);

    public void deleteUserRoles(@Param("userId") Integer id);
}
