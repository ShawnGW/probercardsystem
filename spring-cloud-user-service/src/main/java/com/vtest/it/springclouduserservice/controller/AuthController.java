package com.vtest.it.springclouduserservice.controller;

import com.vtest.it.springclouduserservice.service.auth.AuthService;
import common.domain.Role;
import common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @DeleteMapping("/role/{roleName}")
    public void removeRole(@PathVariable("roleName") String roleName) {
        authService.removeRole(roleName);
    }

    @GetMapping("/role/{roleName}")
    public Role getRole(@PathVariable("roleName") String roleName) {
        return authService.getRole(roleName);
    }

    @GetMapping("/roles/{id}")
    public List<Role> getAllRolesByUserId(@PathVariable("id") Integer id) {
        return authService.getAllRolesByUserId(id);
    }

    @GetMapping("/roles/all")
    public List<Role> getAllRoles() {
        return authService.getAllRoles();
    }

    @GetMapping("/user/all")
    public List<User> getAllUser() {
        return authService.getAllUser();
    }

    @DeleteMapping("/user/{username}")
    public void removeUser(@PathVariable("username") String username) {
        authService.removeUser(username);
    }

    @PutMapping("/user/")
    public void updateUser(User userAdd) {
        authService.updateUser(userAdd);
    }

    @PostMapping("/user/")
    public void register(User userNew) {
        authService.register(userNew);
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable("username") String username) {
        return authService.getUser(username);
    }
}
