package com.example.software.Service;

import com.example.software.Entity.User;

public interface UserService {

    User getUser(String id);

    User getUserByUsername(String username);

    boolean createUser(User user);

    boolean deleteUser(User user);

    boolean loginValidation(String username,String password);
}