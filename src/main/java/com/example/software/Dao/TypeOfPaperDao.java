package com.example.software.Dao;

import com.example.software.Entity.DiaryDetail.PaperColor;
import com.example.software.Entity.DiaryDetail.TypeOfPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeOfPaperDao extends JpaRepository<TypeOfPaper,String> {
    Optional<TypeOfPaper> findTypeOfPaperByTypeOfPaper(String TypeOfPaper);
    Optional<TypeOfPaper> deleteTypeOfPaperById(String TypeOfPaper);
}
