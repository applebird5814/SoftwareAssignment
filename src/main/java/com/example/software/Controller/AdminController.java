package com.example.software.Controller;

import com.example.software.Entity.Admin;
import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.DiaryDetail.PaperColor;
import com.example.software.Entity.DiaryDetail.TypeOfPaper;
import com.example.software.Entity.DiaryOrder;
import com.example.software.Entity.Response;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

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

    @RequestMapping("/index")
    public String adminIndex(HttpServletRequest httpServletRequest)
    {
        if(!validation(httpServletRequest))
        {
            return "AdminLogin";
        }
        return "adminIndex";
    }

    @ResponseBody
    @RequestMapping("/adminlogin")
    public String login(HttpServletRequest httpServletRequest, @RequestBody Admin admin){
        Optional<Admin> optionalAdmin = adminService.login(admin.getUsername(), admin.getPassword());
        if (optionalAdmin.isPresent()) {
            HttpSession httpSession =httpServletRequest.getSession();
            httpSession.setAttribute("admin",optionalAdmin.get());
            // 30 minutes * 60 seconds
            httpSession.setMaxInactiveInterval(30*60);
            String welcome = "Welcome Back, "+optionalAdmin.get().getUsername();
            return new Gson().toJson(new Response(true,welcome));
        } else {
            String error = "Your username or password is incorrect!";
            return new Gson().toJson(new Response(false,error));
        }
    }

    private boolean validation(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession!=null)
        {
            try {
                Admin admin = (Admin) httpSession.getAttribute("admin");
                if(admin == null)
                {
                    return false;
                }
                return true;
            }catch (Exception e)
            {

            }
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest)
    {
        HttpSession httpSession =httpServletRequest.getSession();
        httpSession.removeAttribute("admin");
        return new Gson().toJson(new Response(true,"Admin Sign Out Success!"));
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
    @RequestMapping("/addAdmin")
    public String addAdmin(@RequestBody @Valid Admin admin, BindingResult result)
    {
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
    public String deleteUser(@RequestParam("id") String id)
    {
        Boolean b = adminService.deleteUserById(id);
        if(b)
        {
            String welcome = "Delete Success! User id "+ id +" has been deleted";
            return new Gson().toJson(new Response(true,welcome));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Delete Fail"));
        }
    }

    @ResponseBody
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(@RequestParam("id") String id)
    {
        Boolean b = adminService.deleteAdminById(id);
        if(b)
        {
            String welcome = "Delete Success! Admin id "+ id +" has been deleted";
            return new Gson().toJson(new Response(true,welcome));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Delete Fail"));
        }

    }

    @RequestMapping("/addNewAdmin")
    public String addNewAdmin(HttpServletRequest httpServletRequest)
    {
        if(!validation(httpServletRequest)){
            return "AdminLogin";
        }
        return "AdminRegister";
    }

    @RequestMapping("/login")
    public String adminLogin()
    {
        return "AdminLogin";
    }

    @RequestMapping("/manageDiaryOption")
    public String manageDiaryOption(HttpServletRequest httpServletRequest,Model model)
    {
        if(!validation(httpServletRequest)){
            return "AdminLogin";
        }
        model.addAttribute("TypeOfPaper",new Gson().toJson(diaryService.getTypeOfPapers()));
        model.addAttribute("Color",new Gson().toJson(diaryService.getPaperColors()));
        model.addAttribute("Cover",new Gson().toJson(diaryService.getCovers()));
        return "EditDiaryOption";
    }

    @RequestMapping("/manageAccount")
    public String manageAccount(HttpServletRequest httpServletRequest,Model model)
    {
        if(!validation(httpServletRequest)){
            return "AdminLogin";
        }
        model.addAttribute("Admin",new Gson().toJson(adminService.findAll()));
        model.addAttribute("User",new Gson().toJson(userService.findAll()));

        return "ManageAccount";
    }

    @RequestMapping("/manageOrder")
    public String manageOrder(HttpServletRequest httpServletRequest,Model model){
        if(!validation(httpServletRequest))
        {
            return "AdminLogin";
        }
        model.addAttribute("Order",new Gson().toJson(orderService.getAllOrder()));
        return "ManageOrder";
    }

    @ResponseBody
    @RequestMapping("/AdminRegister")
    public String adminRegister(@RequestBody @Valid Admin user, BindingResult result){
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

    @ResponseBody
    @RequestMapping("/addCover")
    public String addCover(@RequestBody @Valid Cover cover)
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
    @RequestMapping("/addPaperColorName")
    public String addPaperColor(@RequestBody @Valid PaperColor paperColor)
    {
        Boolean b = diaryService.addPaperColor(paperColor);
        if(b)
        {
            return new Gson().toJson(new Response(true,"Add paperColor success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's a paperColor with the same information!"));
        }
    }

    @ResponseBody
    @RequestMapping("/addTypeOfPaper")
    public String addTypeOfPaper(@RequestBody @Valid TypeOfPaper typeOfPaper)
    {
        Boolean b = diaryService.addTypeOfPaper(typeOfPaper);
        if(b)
        {
            return new Gson().toJson(new Response(true,"Add typeOfPaper success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's a typeOfPaper with the same information!"));
        }
    }


    @ResponseBody
    @RequestMapping("/deleteCover")
    public String deleteCover(@RequestParam("id") String id)
    {
        Boolean b = diaryService.deleteCover(id);
        System.out.println(b);
        if(b)
        {
            return new Gson().toJson(new Response(true,"delete cover success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's no cover with the same information!"));
        }
    }

    @ResponseBody
    @RequestMapping("/deletePaperColor")
    public String deletePaperColor(@RequestParam("id") String id)
    {
        Boolean b = diaryService.deletePaperColor(id);
        if(b)
        {
            return new Gson().toJson(new Response(true,"delete paperColor success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's no paperColor with the same information!"));
        }
    }

    @RequestMapping("deletePaperType")
    @ResponseBody
    public String deleteTypeOfPaper(@RequestParam("id") String id)
    {
        Boolean b = diaryService.deleteTypeOfPaper(id);
        if(b)
        {
            return new Gson().toJson(new Response(true,"delete typeOfPaper success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's no typeOfPaper with the same information!"));
        }
    }

}
