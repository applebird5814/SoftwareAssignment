package com.example.software.Controller;

import com.example.software.Entity.Address;
import com.example.software.Entity.Response;
import com.example.software.Entity.User;
import com.example.software.Service.AddressService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/address")
@Controller
public class AddressController {

    @Autowired
    @Qualifier("AddressServiceImpl")
    AddressService addressService;

    @ResponseBody
    @RequestMapping("/createAddress")
    public String createAddress(@RequestBody Address address, HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("user");
        address.setUserId(user.getId());
        Boolean b = addressService.createAddress(address);
        if (b) {
            return new Gson().toJson(new Response(true, "created!"));
        } else {
            return new Gson().toJson(new Response(false, "Error, please try again"));
        }
    }

    @ResponseBody
    @RequestMapping("/deleteAddress")
    public String deleteAddress(@RequestParam("id") String id) {
        Boolean b = addressService.deleteAddress(id);
        if (b) {
            return new Gson().toJson(new Response(true, "deleted!"));
        } else {
            return new Gson().toJson(new Response(false, "Error, please try again"));
        }
    }

}
