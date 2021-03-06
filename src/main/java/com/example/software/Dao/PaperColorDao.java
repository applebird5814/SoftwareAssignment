package com.example.software.Dao;

import com.example.software.Entity.DiaryDetail.PaperColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaperColorDao extends JpaRepository<PaperColor, String> {

    Optional<PaperColor> findPaperColorByColor(String color);

    Optional<PaperColor> findPaperColorById(String id);

    @Override
    void deleteById(String id);
}
