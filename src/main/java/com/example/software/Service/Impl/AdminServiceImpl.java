package com.example.software.Service.Impl;


import com.example.software.Dao.AdminDao;
import com.example.software.Entity.Admin;
import com.example.software.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getUser(String id) {
        return adminDao.findById(id).get();
    }

    @Override
    public Admin getUserByUsername(String username) {
        return adminDao.findByUsername(username).get();
    }

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
    public boolean deleteAdmin(Admin admin) {

        if(adminDao.findByUsername(admin.getUsername()).isPresent())
        {
            adminDao.delete(admin);
            return true;
        }
        return false;

    }

    @Override
    public boolean loginValidation(String username, String password) {
        if(!adminDao.findByUsernameAndPassword(username,password).isEmpty())
        {
            return true;
        }
        return false;
    }
}
