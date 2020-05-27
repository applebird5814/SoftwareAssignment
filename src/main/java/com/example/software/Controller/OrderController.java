package com.example.software.Controller;

import com.example.software.Entity.Diary;
import com.example.software.Entity.DiaryOrder;
import com.example.software.Entity.Response;
import com.example.software.Entity.User;
import com.example.software.Service.AddressService;
import com.example.software.Service.DiaryService;
import com.example.software.Service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @Autowired
    @Qualifier("diaryServiceImpl")
    DiaryService diaryService;

    @Autowired
    @Qualifier("AddressServiceImpl")
    AddressService addressService;

    @ResponseBody
    @RequestMapping("/addDiary")
    public String addDiary(@RequestBody Diary diary, HttpServletRequest httpServletRequest){
        ArrayList<Diary> list;
        diary.setId((int)System.currentTimeMillis() / 1000);
        HttpSession httpSession =httpServletRequest.getSession();
        try{
            list=(ArrayList<Diary>) httpSession.getAttribute("items");
            if(list==null)
            {
                list=new ArrayList<>();
            }
            list.add(diary);
            System.out.println("add " + diary);
            httpSession.setAttribute("items",list);
            httpSession.setMaxInactiveInterval(30*60);
            return new Gson().toJson(new Response(true,"add success"));
        }catch (Exception e)
        {

        }
        return new Gson().toJson(new Response(false,"add fail"));
    }

    @ResponseBody
    @RequestMapping("/removeDiary")
    public String removeDiary(HttpServletRequest httpServletRequest, @RequestParam("id")int id){
        ArrayList<Diary> list;
        HttpSession httpSession =httpServletRequest.getSession();
        try{
            list=(ArrayList<Diary>) httpSession.getAttribute("items");
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getId()==id)
                {
                    System.out.println("remove " + list.get(i));
                    list.remove(i);
                    break;
                }
            }
            return new Gson().toJson(new Response(true,"remove success"));
        }catch (Exception e)
        {

        }
        return new Gson().toJson(new Response(false,"remove fail"));
    }


    @RequestMapping("/shoppingCart")
    public String shoppingCart(HttpServletRequest httpServletRequest,Model model){
        HttpSession httpSession =httpServletRequest.getSession();
        model.addAttribute("Products",new Gson().toJson(httpSession.getAttribute("items")));
        return "shoppingCart";
    }

    @RequestMapping("/checkout")
    public String checkOut(HttpServletRequest httpServletRequest,Model model){
        HttpSession httpSession =httpServletRequest.getSession();
        DiaryOrder diaryOrder = new DiaryOrder();
        diaryOrder.setId((int)System.currentTimeMillis()/1000);
        diaryOrder.setTime(new Date().toString());
        User user =(User)httpSession.getAttribute("user");
        diaryOrder.setUserId(user.getId());
        diaryOrder.setState("waiting for address");
        httpSession.setAttribute("order",diaryOrder);
        model.addAttribute("Address",new Gson().toJson(addressService.findByUserId(user.getId())));
        return "AddAddressAndDeliverOption";
    }

    @ResponseBody
    @RequestMapping("/addAddressAndDeliverOption")
    public String addAddressAndDeliverOption(HttpServletRequest httpServletRequest,@RequestBody DiaryOrder diaryOrder){
        HttpSession httpSession =httpServletRequest.getSession();
        DiaryOrder order = (DiaryOrder) httpSession.getAttribute("order");
        order.setAddress(diaryOrder.getAddress());
        order.setDeliverOption(diaryOrder.getDeliverOption());
        order.setState("waiting for deliver");
        boolean b = orderService.createOrder(order);
        if(b){
            ArrayList<Diary> list=(ArrayList<Diary>) httpSession.getAttribute("items");
            for(int i=0;i<list.size();i++)
            {
                list.get(i).setOrderId(order.getId());
            }
            diaryService.addDiary(list);
            httpSession.removeAttribute("items");
            return new Gson().toJson(new Response(true,"Your order has been placed"));
        }
        else {
            return new Gson().toJson(new Response(false,"Something wrong happens, please try again"));
        }
    }


    @ResponseBody
    @RequestMapping("/paymentSuccess")
    public String finishOrder(@RequestBody DiaryOrder diaryOrder){
        //更新order内容，前端提供了更新了地址和deliver option的一个新的order对象
        //返回一个gson字符串
        return "gson";
    }

}
