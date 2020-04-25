package com.example.software.Controller;

import com.example.software.Entity.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/comment")
@Controller
public class CommentController {

    @ResponseBody
    @RequestMapping("/addComment")
    private String addComment(@RequestBody @Valid Comment comment)
    {
        //添加comment
        //返回gson
        return "gson";
    }

    @RequestMapping("/viewComment")
    private String viewComment(Model model){
        //添加commentall信息
        //返回页面
        // test
        return "viewComment";
    }


}
