package com.example.software.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @RequestMapping("/*")
    @ResponseBody
    public String HelloWorld()
    {
        return "hello world";
    }

    @RequestMapping("/index")
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

    @RequestMapping("/editOrder")
    public String editOrder()
    {
        return "editOrder";
    }

    @RequestMapping("/AdminRegister")
    public String AdminRegister()
    {
        return "AdminRegister";
    }

    @RequestMapping("/AddAddressAndDeliverOption")
    public String AddAddressAndDeliverOption()
    {
        return "AddAddressAndDeliverOption";
    }

    @RequestMapping("/Customization")
    public String Customization()
    {
        return "Customization";
    }


}
