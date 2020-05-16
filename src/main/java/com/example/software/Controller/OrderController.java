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
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/addDiary")
    public String addDiary(Model model, @RequestBody Diary diary){
        //添加各种选项的值
        //返回页面
        System.out.println("Data");
        System.out.println(diary);
        return "addDiary";
    }

    @ResponseBody
    @RequestMapping("/addDiary/submit")
    public String submitAddDiary(@RequestBody Diary diary){
        //将该日记加入session中
        //返回gson数据，告知是否成功
        return "gson";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart(){
        //将所有session中的日记以及数量展示在web中
        //返回页面
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
