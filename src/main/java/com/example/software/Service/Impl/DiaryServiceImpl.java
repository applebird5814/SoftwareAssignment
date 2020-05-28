package com.example.software.Service.Impl;


import com.example.software.Dao.CoverDao;
import com.example.software.Dao.DiaryDao;
import com.example.software.Dao.PaperColorDao;
import com.example.software.Dao.TypeOfPaperDao;
import com.example.software.Entity.Diary;
import com.example.software.Entity.DiaryDetail.Cover;
import com.example.software.Entity.DiaryDetail.PaperColor;
import com.example.software.Entity.DiaryDetail.TypeOfPaper;
import com.example.software.Service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("diaryServiceImpl")
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private CoverDao coverDao;

    @Autowired
    private TypeOfPaperDao typeOfPaperDao;

    @Autowired
    private PaperColorDao paperColorDao;

    @Autowired
    private DiaryDao diaryDao;

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

    @Transactional
    @Override
    public boolean addCover(Cover cover) {
        if (coverDao.findCoverByCoverName(cover.getCoverName()).isPresent()) {
            return false;
        }
        coverDao.saveAndFlush(cover);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteCover(String id) {
        System.out.println(id);
        System.out.println(coverDao.findCoverByCoverName("111").isPresent());
        System.out.println(coverDao.findCoverById(id).isPresent());
        System.out.println(coverDao.findCoverById(id).toString());
        if (coverDao.findCoverById(id).isPresent()) {
            coverDao.deleteById(id);
            coverDao.flush();
            return true;
        }
        return false;
    }


    @Transactional
    @Override
    public boolean addPaperColor(PaperColor color) {
        if (paperColorDao.findPaperColorByColor(color.getColor()).isPresent()) {
            return false;
        }
        paperColorDao.saveAndFlush(color);
        return true;
    }

    @Transactional
    @Override
    public boolean deletePaperColor(String id) {
        if (paperColorDao.findPaperColorById(id).isPresent()) {
            System.out.println(id);
            paperColorDao.deleteById(id);
            paperColorDao.flush();
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean addTypeOfPaper(TypeOfPaper typeOfPaper) {
        if (typeOfPaperDao.findTypeOfPaperByTypeOfPaper(typeOfPaper.getTypeOfPaper()).isPresent()) {
            return false;
        }
        System.out.println(typeOfPaper.getId());
        System.out.println(typeOfPaper.getTypeOfPaper());
        typeOfPaperDao.saveAndFlush(typeOfPaper);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteTypeOfPaper(String id) {
        if (typeOfPaperDao.findTypeOfPaperById(id).isPresent()) {
            System.out.println(id);
            typeOfPaperDao.deleteById(id);
            typeOfPaperDao.flush();
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean addDiary(ArrayList<Diary> list) {
        diaryDao.saveAll(list);
        return true;
    }


}
