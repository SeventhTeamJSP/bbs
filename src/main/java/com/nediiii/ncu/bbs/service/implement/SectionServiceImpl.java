package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.SectionEntity;
import com.nediiii.ncu.bbs.repository.SectionRepository;
import com.nediiii.ncu.bbs.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<SectionEntity> insertSections(List<SectionEntity> sectionList) {
        for (SectionEntity section : sectionList) {
            section.setId(0);
        }
        return sectionRepository.saveAll(sectionList);
    }

    @Override
    public boolean deleteSections(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            sectionRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteSections() {
        sectionRepository.deleteAll();
        return true;
    }

    @Override
    public List<SectionEntity> updateSections(List<SectionEntity> sectionList) {
        return sectionRepository.saveAll(sectionList);
    }

    @Override
    public SectionEntity selectSection(int id) {
        SectionEntity section = null;
        try {
            Optional<SectionEntity> optional = sectionRepository.findById(id);
            section = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return section;
    }

    @Override
    public SectionEntity selectSection(String name) {
        return null;
    }

    @Override
    public List<SectionEntity> selectSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Iterator<SectionEntity> selectSections(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<SectionEntity> sections = sectionRepository.findAll(pageable);
        Iterator<SectionEntity> sectionIterator = sections.iterator();
        return sectionIterator;
    }
}
