package com.vtest.it.springclouduserservice.service.auth.impl;

import com.vtest.it.springclouduserservice.dao.auth.RoleDao;
import com.vtest.it.springclouduserservice.dao.auth.UserDao;
import com.vtest.it.springclouduserservice.dao.auth.UserRoleGrantDao;
import com.vtest.it.springclouduserservice.service.auth.AuthService;
import common.domain.Role;
import common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleGrantDao userRoleGrantDao;
    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    @Caching(evict = {
            @CacheEvict(cacheNames = {"ProberCardSystemUserCache"}, key = "'getAllRoles'")
    })
    public void addNewRole(String roleName, String description) {
        roleDao.addNewRole(roleName, description);
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    @Caching(evict = {
            @CacheEvict(cacheNames = {"ProberCardSystemUserCache"}, key = "'getAllRoles'"),
            @CacheEvict(cacheNames = {"ProberCardSystemUserCache"}, key = "'getRole&'+#roleName")
    })
    public void removeRole(String roleName) {
        roleDao.removeRole(roleName);
    }

    @Override
    @Cacheable(cacheNames = {"ProberCardSystemUserCache"}, key = "#root.methodName+'&'+#roleName", unless = "#result == null")
    public Role getRole(String roleName) {
        return roleDao.getRole(roleName);
    }

    @Override
    public List<Role> getAllRolesByUserId(Integer id) {
        return roleDao.getAllRolesByUserId(id);
    }

    @Override
    @Cacheable(cacheNames = {"ProberCardSystemUserCache"}, key = "#root.methodName")
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Cacheable(cacheManager = "cacheManager", cacheNames = {"ProberCardSystemUserCache"}, key = "#root.methodName+'&'+#username", unless = "#result == null")
    public User getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    @Cacheable(cacheManager = "cacheManager", cacheNames = {"ProberCardSystemUserCache"}, key = "#root.methodName")
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    @CacheEvict(cacheManager = "cacheManager", cacheNames = {"ProberCardSystemUserCache"}, key = "'getAllUser'")
    public void removeUser(String username) {
        userDao.removeUser(username);
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    @Caching(evict = {
            @CacheEvict(cacheManager = "cacheManager", cacheNames = {"ProberCardSystemUserCache"}, key = "'getAllUser'"),
            @CacheEvict(cacheManager = "cacheManager", cacheNames = {"ProberCardSystemUserCache"}, key = "'getUser&'+#userAdd.username")
    })
    public void updateUser(User userAdd) {
        userDao.updateUser(userAdd);
    }

    @Override
    @Transactional(transactionManager = "dataSourceTransactionManager", isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    @CacheEvict(cacheManager = "cacheManager", cacheNames = {"ProberCardSystemUserCache"}, key = "'getAllUser'")
    public void register(User userNew) {
        userDao.register(userNew);
        List<Integer> roleList = new ArrayList<>();
        roleList.add(1);
        userRoleGrantDao.grant(userNew.getId(), roleList);
    }
}
