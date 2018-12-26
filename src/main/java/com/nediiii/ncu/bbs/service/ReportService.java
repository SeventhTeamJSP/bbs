package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.ReportEntity;

import java.util.Iterator;
import java.util.List;

public interface ReportService {

    //    增
    public List<ReportEntity> insertReports(List<ReportEntity> reportList);

    //    删
    public boolean deleteReports(List<Integer> ids);

    public boolean deleteReports();

    //    改
    public List<ReportEntity> updateReports(List<ReportEntity> reportList);

    //    查
    public ReportEntity selectReport(int id);

    public List<ReportEntity> selectReports();

    public Iterator<ReportEntity> selectReports(int pageNum, int pageSize);

}
