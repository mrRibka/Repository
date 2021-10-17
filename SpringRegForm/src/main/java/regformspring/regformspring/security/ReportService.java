package regformspring.regformspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.ReportStatus;
import regformspring.regformspring.repository.ReportRepository;

import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report approveById(Long id) throws RuntimeException{
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus(ReportStatus.APPROVED);
        return report;
    }
    public Report unapproveById(Long id){
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus(ReportStatus.UNAPPROVED);
        return report;
    }
    public Report sentById(Long id){
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus(ReportStatus.SENT);
        return report;
    }

    public Report getReportById(Long id){
        return reportRepository.findById(id).orElseThrow();
    }

    public void saveReport(Report report){
        reportRepository.save(report);
    }

    public Report changeDescriptionById(Long id, String description){
        Report report = reportRepository.findById(id).orElseThrow();
        report.setDescription(description);
        return report;
    }
}
