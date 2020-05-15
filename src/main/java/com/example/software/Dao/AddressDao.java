package com.example.software.Dao;

import com.example.software.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AddressDao extends JpaRepository<Address,String> {

    Optional<Address> findByUserId(String userId);

    Optional<Address> findById(String id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Address a where a.userId=?1")
    void deleteByUserId(String userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Address a set a.id=?1,a.address=?2, a.postCode=?3, a.state=?4, a.urban=?5 where a.userId=?6")
    void updateByUserId(String id, String address, String postCode, String state, String urban, String userId);
}
