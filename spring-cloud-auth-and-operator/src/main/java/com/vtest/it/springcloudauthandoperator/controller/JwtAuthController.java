package com.vtest.it.springcloudauthandoperator.controller;

import com.alibaba.fastjson.JSON;
import com.vtest.it.springcloudauthandoperator.service.userService.impl.MyAuthService;
import common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@CrossOrigin
public class JwtAuthController {
    @Autowired
    private MyAuthService authService;

    // login
    @PostMapping(value = "/authentication/login")
    public String createToken(String username, String password) throws AuthenticationException {
        return authService.login(username, password);
    }

    //register
    @PostMapping(value = "/authentication/register")
    public void register(@RequestBody User addedUser) throws AuthenticationException {
        authService.register(addedUser);
    }
}
