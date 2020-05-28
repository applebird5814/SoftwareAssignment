package com.example.software.Dao;

import com.example.software.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, String> {
    Optional<Admin> findByUsernameAndPassword(String username, String password);

    @Override
    Optional<Admin> findById(String id);

    Optional<Admin> findByUsername(String username);


}
