package regformspring.regformspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.ReportStatus;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByEmail(String email);
    List<Report> findAllByStatus(ReportStatus status);
    List<Report> findAllByEmailAndStatus(String email, ReportStatus status);

    Page<Report> findAllByStatus(ReportStatus status, Pageable pageable);
    Page<Report> findAllByEmail(String email, Pageable pageable);
    Page<Report> findAllByEmailAndStatus(String email, ReportStatus status, Pageable page);

}
