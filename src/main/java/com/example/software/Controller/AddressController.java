package com.example.software.Controller;

import com.example.software.Entity.Address;
import com.example.software.Entity.Response;

import com.example.software.Service.AddressService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/address")
@Controller
public class AddressController {

    @Autowired
    @Qualifier("AddressServiceImpl")
    AddressService addressService;

    @ResponseBody
    @RequestMapping("/createAddress")
    public String createAddress(@RequestBody Address address){
        System.out.println(address.getId());
        Boolean b = addressService.createAddress(address);
        if(b)
        {
            return new Gson().toJson(new Response(true,"created!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"You have created address already, a user can only has one address"));
        }
    }

    @ResponseBody
    @RequestMapping("/deleteAddress")
    public String deleteAddress(@RequestBody Address address){
        System.out.println(address.getId());
        Boolean b = addressService.deleteAddress(address);
        if(b)
        {
            return new Gson().toJson(new Response(true,"deleted!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"You do not have an address, cannot delete"));
        }
    }

    @ResponseBody
    @RequestMapping("/updateAddress")
    public String updateAddress(@RequestBody Address address){
        System.out.println(address.getId());
        Boolean b = addressService.updateAddress(address);
        if(b)
        {
            return new Gson().toJson(new Response(true,"updated!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"You do not have an address, cannot update"));
        }
    }


}
