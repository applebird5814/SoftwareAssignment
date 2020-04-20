package com.example.software.Controller;

import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.Response;
import com.example.software.Service.DiaryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    @Qualifier("diaryServiceImpl")
    DiaryService diaryService;

    @RequestMapping("/")
    public String adminIndex()
    {
        return "adminIndex";
    }

    @RequestMapping("/editDiary")
    public String editDiary(Model model, @CookieValue(value = "admin",required = false) String admin){
        if(admin==null)
        {
            //返回登录页面
        }
        model.addAttribute(new Gson().toJson(diaryService.getCovers()));
        model.addAttribute(new Gson().toJson(diaryService.getPaperColors()));
        model.addAttribute(new Gson().toJson(diaryService.getTypeOfPapers()));
        //添加所有选项
        //分列展示
        //前端提供add，delete功能
        return "EditDiary";
    }
    //构建多个方法，如/editDiary/cover/add

    @ResponseBody
    @RequestMapping("/editDiary/addCover")
    public String addCover(@Valid Cover cover)
    {
        Boolean b = diaryService.addCover(cover);
        if(b)
        {
            return new Gson().toJson(new Response(true,"Add cover success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's a cover with the same information!"));
        }
    }

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
