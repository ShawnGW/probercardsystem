package com.vtest.it.springclouduserservice.dao.auth;

import common.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public User getUser(@Param("username") String username);
    public List<User> getAllUser();
    public boolean removeUser(@Param("username") String username);
}
