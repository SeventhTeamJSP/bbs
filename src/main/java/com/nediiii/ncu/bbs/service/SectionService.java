package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.SectionEntity;

import java.util.Iterator;
import java.util.List;

public interface SectionService {

    //    增
    public List<SectionEntity> insertSections(List<SectionEntity> sectionList);

    //    删
    public boolean deleteSections(List<Integer> ids);

    public boolean deleteSections();

    //    改
    public List<SectionEntity> updateSections(List<SectionEntity> sectionList);

    //    查
    public SectionEntity selectSection(int id);

    public SectionEntity selectSection(String name);

    public List<SectionEntity> selectSections();

    public Iterator<SectionEntity> selectSections(int pageNum, int pageSize);

}
