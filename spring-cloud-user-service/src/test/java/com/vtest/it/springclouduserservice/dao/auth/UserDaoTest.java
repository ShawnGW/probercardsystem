package com.vtest.it.springclouduserservice.dao.auth;

import com.vtest.it.springclouduserservice.service.auth.AuthService;
import common.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleGrantDao userRoleGrantDao;

    @Autowired
    private AuthService authService;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("jiahao");
        user.setPassword("jiahao");
        user.setEmail("jiahao.haung@v-test.com.cn");
        user.setPhone("11111111111");
        user.setTeam("IT");
        authService.register(user);
    }
}