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

    public void approveById(Long id) throws RuntimeException{
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus(ReportStatus.APPROVED);
        this.reportRepository.save(report);
    }
    public void unapproveById(Long id){
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus(ReportStatus.UNAPPROVED);
        this.reportRepository.save(report);
    }
}
