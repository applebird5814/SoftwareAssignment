package com.example.software.Controller;

import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.DiaryDetail.PaperColor;
import com.example.software.Entity.DiaryDetail.TypeOfPaper;
import com.example.software.Entity.Response;
import com.example.software.Service.DiaryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/cover")
@Controller
public class CController {
    @Autowired
    @Qualifier("diaryServiceImpl")
    DiaryService diaryService;

    @RequestMapping("/test")
    @ResponseBody
    public String a() {
        return "test1";
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
    @RequestMapping("/deleteCoverName")
    public String deleteCover(@RequestBody @Valid String id)
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
    @RequestMapping("/deletePaperColorName")
    public String deletePaperColor(@RequestBody @Valid String id)
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


    @RequestMapping("deleteTypeofPaper")
@ResponseBody
    public String deleteTypeOfPaper(@RequestBody @Valid String id)
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

    @RequestMapping("/testjsp")
    public String showcover(Model model) {
        List<Cover> showcover = diaryService.getCovers();//加这行，调用Service层的业务
        model.addAttribute("showcover", showcover);//加这行，传个list到前端
        System.out.println(showcover.toArray());
        return "EditDiary";
    }
}
