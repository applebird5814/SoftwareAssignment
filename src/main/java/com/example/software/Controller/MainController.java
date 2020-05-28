package com.example.software.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/*")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/register")
    public String register()
    {
        return "Register";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "Login";
    }

    @RequestMapping("/homePage")
    public String homePage()
    {
        return "HomePage";
    }


}
