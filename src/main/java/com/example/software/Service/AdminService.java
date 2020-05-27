package com.example.software.Service;

import com.example.software.Entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin getUser(String id);

    Admin getUserByUsername(String username);

    boolean createAdmin(Admin admin);

    boolean deleteAdmin(Admin admin);

    Optional<Admin> login(String username,String password);

    List<Admin> findAll();

    boolean deleteUserById(String id);

    boolean deleteAdminById(String id);
}
