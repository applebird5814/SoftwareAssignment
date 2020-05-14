package com.example.software.Controller;

import com.example.software.Entity.Comment;
import com.example.software.Entity.Response;
import com.example.software.Service.CommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/comment")
@Controller
public class CommentController {

    @Autowired
    @Qualifier("CommentServiceImpl")
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/addComment")
    private String addComment(@RequestBody @Valid Comment comment)
    {
        //添加comment
        //返回gson

        Boolean b = commentService.createComment(comment);
        if(b)
        {
            return new Gson().toJson(new Response(true,"add a new comment Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"comment id already exist！"));
        }

    }

    @ResponseBody
    @RequestMapping("/deleteComment")
    public String deleteUser(@RequestBody Comment comment)
    {
        //添加所有user账户和admin账户
        //前端提供添加管理员功能以及删除用户功能

        //删除用户
        Boolean b = commentService.deleteComment(comment);

        if(b)
        {
            String welcome = "Delete Success!"+ comment.getId() +" has been deleted";
            return new Gson().toJson(new Response(true,welcome));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Delete Fail"));
        }

    }

    @RequestMapping("/viewComment")
    private String viewComment(Model model){
        //添加commentall信息
        //返回页面
        // test
        return "viewComment";
    }


}
