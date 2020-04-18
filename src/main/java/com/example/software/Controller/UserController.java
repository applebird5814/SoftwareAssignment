package com.example.software.Controller;

import com.example.software.Entity.Response;
import com.example.software.Entity.User;
import com.example.software.Service.UserService;
import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        Boolean b = userService.loginValidation(user.getUsername(),user.getPassword());
        if(b)
        {
            return new Gson().toJson(new Response(true,"Login Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Username or password is incorrect!"));
        }
        //此处接收User对象并判断是否存在于数据库
        //成功返回成功信息
        //调用session添加信息
        //失败返回失败信息
        //返回为json数据，前端通过ajax决定跳转页面或者显示alert，用户名或密码错误
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return new Gson().toJson(new Response(false,"Invalid Information"));
        }
        Boolean b = userService.createUser(user);
        if(b)
        {
            return new Gson().toJson(new Response(true,"Register Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"User already exist！"));
        }
    }

    @RequestMapping("/history")
    public String history(){
        //添加该user的所有history
        //返回页面
        return "history";
    }

}
