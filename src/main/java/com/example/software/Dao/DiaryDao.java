package com.example.software.Dao;

import com.example.software.Entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryDao extends JpaRepository<Diary,Integer> {
}
