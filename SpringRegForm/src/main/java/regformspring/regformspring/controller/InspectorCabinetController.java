package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.ReportStatus;
import regformspring.regformspring.model.User;
import regformspring.regformspring.repository.ReportRepository;
import regformspring.regformspring.repository.UserRepository;
import regformspring.regformspring.security.ReportService;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/cabinet/inspector")
public class InspectorCabinetController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/show")
    public String getShowPage(Model model){
        return findPaginated(1, model);
    }

    @GetMapping("/approve/{id}")
    public String approve(@PathVariable(value = "id") Long id){
        reportService.saveReport(reportService.approveById(id));
        return "redirect:/cabinet/inspector/show";
    }

    @GetMapping("/unapprove/{id}")
    public String unapprove(@PathVariable(value = "id") Long id, Model model){

        model.addAttribute("report", reportService.getReportById(id));
        return "inspector.unapprove";
    }

    @PostMapping("/saveReport")
    public String saveReport(@RequestParam Long id,@RequestParam String description){

        reportService.saveReport(reportService.unapproveById(id));
        reportService.saveReport(reportService.changeDescriptionById(id, description));
        return "redirect:/cabinet/inspector/show";
    }

    @GetMapping("/filterByEmail/{email}")
    public String filterByEmail(@PathVariable(value = "email") String email, Model model){

        Iterable<Report> reports = reportService.findAllByEmail(email);
        model.addAttribute("reports", reports);
        return "inspector.cabinet.show";
    }

    @GetMapping("/filterByStatus/{status}/{email}")
    public String filterByStatus(@PathVariable(value = "status") ReportStatus status, @PathVariable(value = "email") String email, Model model){

        Iterable<Report> reports = reportService.findAllByEmailAndStatus(email, status);
        model.addAttribute("reports", reports);
        return "inspector.cabinet.show";
    }

    @GetMapping("/show/{pageNumber}")
    public String findPaginated(@PathVariable(value = "pageNumber") int pageNumber, Model model){
        int pageSize = 5;

        Page<Report> page = reportService.findPaginated(pageNumber, pageSize);
        List<Report> reports = page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("reports", reports);

        return "inspector.cabinet.show";
    }
}
