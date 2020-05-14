package com.example.software.Service;

import com.example.software.Entity.Comment;

public interface CommentService {

    Comment getComment(String id);

    boolean createComment(Comment comment);

    boolean deleteComment(Comment comment);

}
