package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.SectionEntity;
import com.nediiii.ncu.bbs.service.implement.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SectionController {

    @Autowired
    private SectionServiceImpl sectionService;

    @PostMapping("/sections")
    public Object addSection(@RequestBody List<SectionEntity> sectionList) {
        sectionList = sectionService.insertSections(sectionList);
        return sectionList;
    }

    @DeleteMapping("/sections")
    public Object deleteSection(@RequestBody List<Integer> ids) {
        return sectionService.deleteSections(ids);
    }

    @DeleteMapping("/sections/all")
    public Object deleteSection() {
        return sectionService.deleteSections();
    }

    @PutMapping("/sections")
    public Object updateSection(@RequestBody List<SectionEntity> sectionList) {
        sectionList = sectionService.updateSections(sectionList);
        return sectionList;
    }

    @GetMapping("/sections/{id}")
    public Object getSectionById(@PathVariable int id) {
        SectionEntity section = sectionService.selectSection(id);
        return new ResponseEntity<>(
                section,
                section == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/sections")
    public Object getSections() {
        return sectionService.selectSections();
    }
}
