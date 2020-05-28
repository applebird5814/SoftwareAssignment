package com.example.software.Service;

import com.example.software.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean createUser(User user);

    Optional<User> login(String username, String password);

    List<User> findAll();
}