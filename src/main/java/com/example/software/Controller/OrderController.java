package com.example.software.Controller;

import com.example.software.Entity.Diary;
import com.example.software.Entity.DiaryOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/order")
@Controller
public class OrderController {

    @RequestMapping("/addDiary")
    public String addDiary(Model model){
        //添加各种选项的值
        //返回页面
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
    @RequestMapping("/paymentSuccess")
    public String finishOrder(@RequestBody DiaryOrder diaryOrder){
        //更新order内容，前端提供了更新了地址和deliver option的一个新的order对象
        //返回一个gson字符串
        return "gson";
    }

}
