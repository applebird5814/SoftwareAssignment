package com.example.software;

import com.example.software.Entity.Address;
import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.DiaryDetail.PaperColor;
import com.example.software.Entity.DiaryDetail.TypeOfPaper;
import com.example.software.Service.AddressService;
import com.example.software.Service.DiaryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DairyServiceTest extends SoftwareApplicationTests {

    @Autowired
    @Qualifier("diaryServiceImpl")
    DiaryService diaryService;

    @Test
    public void ACreateCover(){
        Cover cover = new Cover();
        cover.setId("A");
        cover.setCoverName("AA");
        Assert.assertSame("create success",true,diaryService.addCover(cover));
    }

    @Test
    public void BCreateCover(){
        Cover cover = new Cover();
        cover.setId("A");
        cover.setCoverName("AA");
        Assert.assertSame("create success",false,diaryService.addCover(cover));
    }

    @Test
    public void CgetCover(){
        Assert.assertSame("get success",1,diaryService.getCovers().size());
    }

    @Test
    public void DDeleteCover(){
        Assert.assertSame("delete error ",true,diaryService.deleteCover("A"));
    }

    @Test
    public void EDeleteCover(){
        Assert.assertSame("delete error ",false,diaryService.deleteCover("A"));
    }


    @Test
    public void FCreatepapercolor(){
        PaperColor paperColor = new PaperColor();
        paperColor.setId("A");
        paperColor.setColor("AA");
        Assert.assertSame("create success",true,diaryService.addPaperColor(paperColor));
    }

    @Test
    public void GCreateType(){
        TypeOfPaper type = new TypeOfPaper();
        type.setId("A");
        type.setTypeOfPaper("AA");
        Assert.assertSame("create success",true,diaryService.addTypeOfPaper(type));
    }

    @Test
    public void HDeletePapercolor(){
        Assert.assertSame("delete success ",true,diaryService.deletePaperColor("A"));
    }

    @Test
    public void IDeleteType(){
        Assert.assertSame("delete error ",true,diaryService.deleteTypeOfPaper("A"));
    }
}



