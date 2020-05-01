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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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
    public String addCover(@Valid Cover cover)
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
//aaa
    public String addPaperColor(@Valid PaperColor paperColor)
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

    public String addTypeOfPaper(@Valid TypeOfPaper typeOfPaper)
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

    public String deleteCover(@Valid Cover cover)
    {
        Boolean b = diaryService.deleteCover(cover);
        if(b)
        {
            return new Gson().toJson(new Response(true,"delete cover success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's no cover with the same information!"));
        }
    }

    public String deletePaperColor(@Valid PaperColor paperColor)
    {
        Boolean b = diaryService.deletePaperColor(paperColor);
        if(b)
        {
            return new Gson().toJson(new Response(true,"delete paperColor success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's no paperColor with the same information!"));
        }
    }

    public String deleteTypeOfPaper(@Valid TypeOfPaper typeOfPaper)
    {
        Boolean b = diaryService.deleteTypeOfPaper(typeOfPaper);
        if(b)
        {
            return new Gson().toJson(new Response(true,"delete typeOfPaper success"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"There's no typeOfPaper with the same information!"));
        }
    }
}
