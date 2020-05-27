package com.example.software.Dao;

import com.example.software.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface AddressDao extends JpaRepository<Address,String> {

    List<Address> findByUserId(String userId);

    @Override
    Optional<Address> findById(String id);

    void deleteAddressById(String id);

}
