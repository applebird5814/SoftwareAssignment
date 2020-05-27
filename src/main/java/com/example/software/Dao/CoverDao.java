package com.example.software.Dao;

import com.example.software.Entity.DiaryDetail.Cover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CoverDao extends JpaRepository<Cover,String> {
    Optional<Cover> findCoverByCoverName(String coverName);

    Optional<Cover> findCoverById(String id);

    void deleteCoverById(String id);

}
