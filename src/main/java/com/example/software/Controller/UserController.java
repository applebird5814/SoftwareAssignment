package com.example.software.Controller;

import com.example.software.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/user")
@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "gson,提示非法";
        }
        //此处接收User对象并判断是否存在于数据库
        //成功返回成功信息
        //调用session添加信息
        //失败返回失败信息
        //返回为json数据，前端通过ajax决定跳转页面或者显示alert，用户名或密码错误
        return "gson";
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "gson,提示非法";
        }
        //向数据库插入新的用户
        //向前端返回json数据表明是否插入成功
        //前端进行跳转
        return "gson";
    }

    @RequestMapping("/history")
    public String history(){
        //添加该user的所有history
        //返回页面
        return "history";
    }

}
