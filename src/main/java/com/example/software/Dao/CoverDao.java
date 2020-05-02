package com.example.software.Dao;

import com.example.software.Entity.DiaryDetail.Cover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CoverDao extends JpaRepository<Cover,String> {
    Optional<Cover> findCoverByCoverName(String coverName);
    void deleteCoverByCoverName(String coverName);
    ///aaaaaaaaaa
}
