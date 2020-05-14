package com.example.software.Service.Impl;


import com.example.software.Dao.UserDao;
import com.example.software.Entity.User;
import com.example.software.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username).get();
    }



    @Override
    public boolean createUser(User user) {
        if(userDao.findByUsername(user.getUsername()).isPresent())
        {
            return false;
        }
        userDao.saveAndFlush(user);
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        if(userDao.findByUsername(user.getUsername()).isPresent())
        {
            userDao.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginValidation(String username, String password) {
        if(!userDao.findByUsernameAndPassword(username,password).isEmpty())
        {
            return true;
        }
        return false;
    }

}