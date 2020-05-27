package com.example.software.Controller;

import com.example.software.Entity.Diary;
import com.example.software.Entity.DiaryOrder;
import com.example.software.Entity.Response;
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
import java.util.UUID;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

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

    @ResponseBody
    @RequestMapping("/addDiary/submit")
    public String submitAddDiary(@RequestBody Diary diary){
        //将该日记加入session中
        //返回gson数据，告知是否成功
        return "gson";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart(HttpServletRequest httpServletRequest,Model model){
        HttpSession httpSession =httpServletRequest.getSession();
        model.addAttribute("Products",new Gson().toJson(httpSession.getAttribute("items")));
        return "shoppingCart";
    }

    @RequestMapping("/checkout")
    public String checkOut(){
        //生成一个order对象
        //将order对象返还给前端
        //进入地址选择阶段
        //将地址信息列表以及运送方式列表返回给前端
        return "选择地址以及运送方式页面";
    }

    @ResponseBody
    @RequestMapping("/addAddressAndDeliverOption")
    public String addAddressAndDeliverOption(@RequestBody DiaryOrder diaryOrder){
        System.out.println(diaryOrder.getId());
        Boolean b = orderService.addAddressAndDeliverOption(diaryOrder.getId(),diaryOrder.getAddress(),diaryOrder.getDeliverOption());
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
    @RequestMapping("/paymentSuccess")
    public String finishOrder(@RequestBody DiaryOrder diaryOrder){
        //更新order内容，前端提供了更新了地址和deliver option的一个新的order对象
        //返回一个gson字符串
        return "gson";
    }

}
