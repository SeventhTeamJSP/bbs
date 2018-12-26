package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.ReportEntity;
import com.nediiii.ncu.bbs.repository.ReportRepository;
import com.nediiii.ncu.bbs.service.ReportService;
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
public class ReportServiceImpl implements ReportService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<ReportEntity> insertReports(List<ReportEntity> reportList) {
        for (ReportEntity report : reportList) {
            report.setId(0);
        }
        return reportRepository.saveAll(reportList);
    }

    @Override
    public boolean deleteReports(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            reportRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteReports() {
        reportRepository.deleteAll();
        return true;
    }

    @Override
    public List<ReportEntity> updateReports(List<ReportEntity> reportList) {
        return reportRepository.saveAll(reportList);
    }

    @Override
    public ReportEntity selectReport(int id) {
        ReportEntity report = null;
        try {
            Optional<ReportEntity> optional = reportRepository.findById(id);
            report = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return report;
    }

    @Override
    public List<ReportEntity> selectReports() {
        return reportRepository.findAll();
    }

    @Override
    public Iterator<ReportEntity> selectReports(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<ReportEntity> reports = reportRepository.findAll(pageable);
        Iterator<ReportEntity> reportIterator = reports.iterator();
        return reportIterator;
    }
}
