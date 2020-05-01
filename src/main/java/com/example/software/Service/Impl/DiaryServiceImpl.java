package com.example.software.Service.Impl;


import com.example.software.Dao.CoverDao;
import com.example.software.Dao.PaperColorDao;
import com.example.software.Dao.TypeOfPaperDao;
import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.DiaryDetail.PaperColor;
import com.example.software.Entity.DiaryDetail.TypeOfPaper;
import com.example.software.Service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("diaryServiceImpl")
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private CoverDao coverDao;

    @Autowired
    private TypeOfPaperDao typeOfPaperDao;

    @Autowired
    private PaperColorDao paperColorDao;

    @Override
    public List<Cover> getCovers() {
        return coverDao.findAll();
    }

    @Override
    public List<PaperColor> getPaperColors() {
        return paperColorDao.findAll();
    }

    @Override
    public List<TypeOfPaper> getTypeOfPapers() {
        return typeOfPaperDao.findAll();
    }

    @Override
    public boolean addCover(Cover cover) {
        if(coverDao.findCoverByCoverName(cover.getCoverName()).isPresent())
        {
            return false;
        }
        coverDao.saveAndFlush(cover);
        return true;
    }

    @Override
    public boolean deleteCover(Cover cover) {
        if(coverDao.findCoverByCoverName(cover.getCoverName()).isPresent())
        {
            coverDao.deleteInBatch((Iterable<Cover>) cover);
            coverDao.flush();
            return true;
        }
        return false;
    }

    public boolean addPaperColor(PaperColor paperColor) {
        if(paperColorDao.findPaperColorByColor(paperColor.getColor()).isPresent())
        {
            return false;
        }
        paperColorDao.saveAndFlush(paperColor);
        return true;
    }

    public boolean deletePaperColor(PaperColor paperColor) {
        if(paperColorDao.findPaperColorByColor(paperColor.getColor()).isPresent())
        {
            paperColorDao.deleteInBatch((Iterable<PaperColor>) paperColor);
            paperColorDao.flush();
            return true;
        }
        return false;
    }

    public boolean addTypeOfPaper(TypeOfPaper typeOfPaper) {
        if(typeOfPaperDao.findTypeOfPaperBytypeOfPaper(typeOfPaper.getTypeOfPaper()).isPresent())
        {
            return false;
        }
        typeOfPaperDao.saveAndFlush(typeOfPaper);
        return true;
    }

    public boolean deleteTypeOfPaper(TypeOfPaper typeOfPaper) {
        if(typeOfPaperDao.findTypeOfPaperBytypeOfPaper(typeOfPaper.getTypeOfPaper()).isPresent())
        {
            typeOfPaperDao.deleteInBatch((Iterable<TypeOfPaper>) typeOfPaper);
            typeOfPaperDao.flush();
            return true;
        }
        return false;
    }
}
