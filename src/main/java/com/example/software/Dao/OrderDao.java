package com.example.software.Dao;

import com.example.software.Entity.DiaryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderDao extends JpaRepository<DiaryOrder, Integer> {

    @Override
    List<DiaryOrder> findAll();

    Optional<DiaryOrder> findById(int id);

    List<DiaryOrder> findByUserId(String userId);

    void deleteById(int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update DiaryOrder a set a.address=?2,a.deliverOption=?3 where a.id=?1")
    void updateAddressAndDeliverOption(int id, String address, String deliverOption);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update DiaryOrder a set a.state=?2 where a.id=?1")
    void updateStatus(int id, String status);
}
