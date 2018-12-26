package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.ReportEntity;
import com.nediiii.ncu.bbs.service.implement.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping("/reports")
    public Object addReport(@RequestBody List<ReportEntity> reportList) {
        reportList = reportService.insertReports(reportList);
        return reportList;
    }

    @DeleteMapping("/reports")
    public Object deleteReport(@RequestBody List<Integer> ids) {
        return reportService.deleteReports(ids);
    }

    @DeleteMapping("/reports/all")
    public Object deleteReport() {
        return reportService.deleteReports();
    }

    @PutMapping("/reports")
    public Object updateReport(@RequestBody List<ReportEntity> reportList) {
        reportList = reportService.updateReports(reportList);
        return reportList;
    }

    @GetMapping("/reports/{id}")
    public Object getReportById(@PathVariable int id) {
        ReportEntity report = reportService.selectReport(id);
        return new ResponseEntity<>(
                report,
                report == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/reports")
    public Object getReports() {
        return reportService.selectReports();
    }
}
