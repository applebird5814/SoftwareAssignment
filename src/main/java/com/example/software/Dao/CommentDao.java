package com.example.software.Dao;

import com.example.software.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentDao extends JpaRepository<Comment,String> {
    Optional<Comment> findById(String id);

}
