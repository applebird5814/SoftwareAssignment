package com.example.software.Controller;

import com.example.software.Entity.Response;
import com.example.software.Entity.User;
import com.example.software.Service.DiaryService;
import com.example.software.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @Autowired
    @Qualifier("diaryServiceImpl")
    DiaryService diaryService;



    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest httpServletRequest, @RequestBody User user){
        Optional<User> optionalUser = userService.login(user.getUsername(), user.getPassword());
        if (optionalUser.isPresent()) {
            HttpSession httpSession =httpServletRequest.getSession();
            httpSession.setAttribute("user",optionalUser.get());
            // 30 minutes * 60 seconds
            httpSession.setMaxInactiveInterval(30*60);
            String welcome = "Welcome Back, "+optionalUser.get().getScreenName();
            return new Gson().toJson(new Response(true,welcome));
        } else {
            String error = "Your username or password is incorrect!";
            return new Gson().toJson(new Response(false,error));
        }
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

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest)
    {
        HttpSession httpSession =httpServletRequest.getSession();
        httpSession.removeAttribute("user");
        return new Gson().toJson(new Response(true,"Sign Out Success!"));
    }

    @RequestMapping("/history")
    public String history(Model model){
        // To do
        return "History";
    }


    @RequestMapping("/viewDiary")
    public String viewDiary(Model model, HttpServletRequest httpServletRequest)
    {
        if(!validation(httpServletRequest))
        {
            return "Login";
        }
        model.addAttribute(new Gson().toJson(diaryService.getCovers()));
        model.addAttribute(new Gson().toJson(diaryService.getPaperColors()));
        model.addAttribute(new Gson().toJson(diaryService.getTypeOfPapers()));
        return "ViewDiary";
    }

    private boolean validation(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession!=null)
        {
            try {
                User user = (User) httpSession.getAttribute("user");
                if(user == null)
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

}
