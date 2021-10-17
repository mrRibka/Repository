package regformspring.regformspring.repository;

import org.springframework.data.repository.CrudRepository;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.ReportStatus;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findAllByEmail(String email);
    List<Report> findAllByStatus(ReportStatus status);
    List<Report> findAllByEmailAndStatus(String email, ReportStatus status);
}
