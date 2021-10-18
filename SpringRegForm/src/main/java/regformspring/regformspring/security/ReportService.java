package regformspring.regformspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.ReportStatus;
import regformspring.regformspring.repository.ReportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public void save(Report report){
        reportRepository.save(report);
    }

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
    public List<Report> findAllByEmail(String email){
        return reportRepository.findAllByEmail(email);
    }

    public List<Report> findAllByEmailAndStatus(String email, ReportStatus status){
        return reportRepository.findAllByEmailAndStatus(email, status);
    }

    public List<Report> findAllByStatus(ReportStatus status){
        return reportRepository.findAllByStatus(status);
    }

    public Page<Report> findPaginated(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return reportRepository.findAll(pageable);
    }

    public Page<Report> findPaginatedByEmail(int pageNumber, int pageSize, String email){
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return reportRepository.findAllByEmail(email, pageable);
    }

    public Page<Report> findPaginatedByEmailAndStatus(int pageNumber, int pageSize, String email, ReportStatus status){
            Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
            return reportRepository.findAllByEmailAndStatus(email, status, pageable);
        }

}
