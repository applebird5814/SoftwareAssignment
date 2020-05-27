package com.example.software.Dao;

import com.example.software.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin,String> {
    Optional<Admin> findByUsernameAndPassword(String username,String password);

    Optional<Admin> findById(String id);

    Optional<Admin> findByUsername(String username);


}
