package com.vtest.it.springclouduserservice.service.auth.impl;

import com.vtest.it.springclouduserservice.dao.auth.RoleDao;
import com.vtest.it.springclouduserservice.dao.auth.UserDao;
import com.vtest.it.springclouduserservice.service.auth.AuthService;
import common.domain.Role;
import common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void addNewRole(String roleName, String description) {
        roleDao.addNewRole(roleName, description);
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void removeRole(String roleName) {
        roleDao.removeRole(roleName);
    }

    @Override
    public Role getRole(String roleName) {
        return roleDao.getRole(roleName);
    }

    @Override
    public List<Role> getAllRolesByUserId(Integer id) {
        return roleDao.getAllRolesByUserId(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void removeUser(String username) {
        userDao.removeUser(username);
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void updateUser(User userAdd) {
        userDao.updateUser(userAdd);
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void register(User userNew) {
        userDao.register(userNew);
    }
}
