package regformspring.regformspring.repository;

import org.springframework.data.repository.CrudRepository;
import regformspring.regformspring.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findAllByEmail(String email);
}
