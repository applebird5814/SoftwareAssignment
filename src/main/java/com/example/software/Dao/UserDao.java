package com.example.software.Dao;


import com.example.software.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User,String> {

    Optional<User> findByUsernameAndPassword(String username,String password);

    @Override
    Optional<User> findById(String id);

    Optional<User> findByUsername(String username);

    @Override
    void deleteById(String id);

}
