package com.example.software.Service;

import com.example.software.Entity.Admin;

public interface AdminService {
    Admin getUser(String id);

    Admin getUserByUsername(String username);

    boolean createAdmin(Admin admin);

    boolean deleteAdmin(Admin admin);

    boolean loginValidation(String username,String password);
}
