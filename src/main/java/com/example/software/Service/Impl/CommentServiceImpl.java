package com.example.software.Service.Impl;


import com.example.software.Dao.CommentDao;
import com.example.software.Entity.Comment;
import com.example.software.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;




    @Override
    public Comment getComment(String id) {
        return commentDao.findById(id).get();

    }

    @Override
    public boolean createComment(Comment comment) {
        if(commentDao.findById(comment.getId()).isPresent())
        {
            return false;
        }
        commentDao.saveAndFlush(comment);
        return true;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        if(commentDao.findById(comment.getId()).isPresent())
        {
            commentDao.delete(comment);
            return true;
        }
        return false;
    }
}
