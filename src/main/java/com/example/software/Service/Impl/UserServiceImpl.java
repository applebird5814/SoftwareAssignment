package com.example.software.Service.Impl;


import com.example.software.Dao.UserDao;
import com.example.software.Entity.User;
import com.example.software.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public boolean createUser(User user) {
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            return false;
        }
        userDao.saveAndFlush(user);
        return true;
    }

    @Override
    public Optional<User> login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}