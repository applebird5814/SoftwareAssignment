package com.example.software.Service.Impl;


import com.example.software.Dao.AdminDao;
import com.example.software.Dao.UserDao;
import com.example.software.Entity.Admin;
import com.example.software.Entity.User;
import com.example.software.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UserDao userDao;

    @Override
    public boolean createAdmin(Admin admin) {
        if(adminDao.findByUsername(admin.getUsername()).isPresent())
        {
            return false;
        }
        adminDao.saveAndFlush(admin);
        return true;
    }


    @Override
    public Optional<Admin> login(String username, String password) {
        return adminDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public boolean deleteUserById(String id) {
        if(userDao.findById(id).isPresent())
        {
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdminById(String id) {
        if(adminDao.findById(id).isPresent())
        {
            adminDao.deleteById(id);
            return true;
        }
        return false;
    }
}
