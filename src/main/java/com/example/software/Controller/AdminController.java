package com.example.software.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @RequestMapping("/")
    public String adminIndex()
    {
        return "adminIndex";
    }

    @RequestMapping("/diaryManger")
    public String diaryManger(Model model){
        //添加所有选项
        //分列展示
        //前端提供add，delete功能
        return "diaryManger";
    }
    //构建多个方法，如/editDiary/cover/add

    @RequestMapping("/accountManger")
    public String accountManger(Model model)
    {
        //添加所有user账户和admin账户
        //前端提供添加管理员功能以及删除用户功能
        return "accountManger";
    }
    //构建多个方法，如/accountManger/addAdmin /accountManager/deleteAccount并接受参数

    @RequestMapping("/orderManger")
    public String orderManger(Model model){
        //添加所有order信息
        return "orderManger";
    }

    @RequestMapping("/commentManger")
    public String commentManger(Model model)
    {
        //添加所有Comment
        return "commentManger";
    }
    //构建删除评论功能


}
