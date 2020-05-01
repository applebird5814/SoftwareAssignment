package com.example.software.Controller;

import com.example.software.Entity.Admin;
import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.DiaryOrder;
import com.example.software.Entity.Response;
import com.example.software.Entity.User;
import com.example.software.Service.AdminService;
import com.example.software.Service.DiaryService;
import com.example.software.Service.OrderService;
import com.example.software.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    @Qualifier("diaryServiceImpl")
    DiaryService diaryService;

    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @Autowired
    @Qualifier("AdminServiceImpl")
    AdminService adminService;

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

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

    @ResponseBody
    @RequestMapping("/changeState")
    public String changeState(@RequestBody DiaryOrder diaryOrder){
        Boolean b = orderService.changeOrderState(diaryOrder.getId(),diaryOrder.getState());
        if(b)
        {
            return new Gson().toJson(new Response(true,"Change Success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Error!"));
        }
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(@RequestBody @Valid User user, BindingResult result)
    {
        //添加所有user账户和admin账户
        //前端提供添加管理员功能以及删除用户功能

        //添加用户
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return new Gson().toJson(new Response(false,"Invalid Information"));
        }

        Boolean b = userService.createUser(user);

        if(b)
        {
            return new Gson().toJson(new Response(true,"add a new user Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"User already exist！"));
        }
    }

    @ResponseBody
    @RequestMapping("/addAdmin")
    public String addAdmin(@RequestBody @Valid Admin admin, BindingResult result)
    {
        //添加所有user账户和admin账户
        //前端提供添加管理员功能以及删除用户功能

        //添加admin
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return new Gson().toJson(new Response(false,"Invalid Information"));
        }

        Boolean b = adminService.createAdmin(admin);

        if(b)
        {
            return new Gson().toJson(new Response(true,"add a new admin Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Admin already exist！"));
        }
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody User user)
    {
        //添加所有user账户和admin账户
        //前端提供添加管理员功能以及删除用户功能

        //删除用户
        Boolean b = userService.deleteUser(user);

        if(b)
        {
            String welcome = "Delete Success!"+ user.getUsername() +" has been deleted";
            return new Gson().toJson(new Response(true,welcome));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Delete Fail"));
        }

    }

    @ResponseBody
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(@RequestBody Admin admin)
    {
        //添加所有user账户和admin账户
        //前端提供添加管理员功能以及删除用户功能

        //删除admin
        Boolean b = adminService.deleteAdmin(admin);

        if(b)
        {
            String welcome = "Delete Success!"+ admin.getUsername() +" has been deleted";
            return new Gson().toJson(new Response(true,welcome));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Delete Fail"));
        }

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


    @ResponseBody
    @RequestMapping("/AdminRegister")
    public String AdminRegister(@RequestBody @Valid Admin user, BindingResult result){
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return new Gson().toJson(new Response(false,"Invalid Information"));
        }
        Boolean b = adminService.createAdmin(user);
        if(b)
        {
            return new Gson().toJson(new Response(true,"Register Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"User already exist！"));
        }
    }


}
