package com.vtest.it.springcloudauthandoperator.service.userService;

import common.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("API-GATEWAY")
public interface UserMicService {
    @RequestMapping(value = "/user-service/auth/user/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username);
}
