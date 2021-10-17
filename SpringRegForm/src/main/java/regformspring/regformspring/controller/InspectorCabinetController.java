package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.Optional;


@Controller
@RequestMapping("/cabinet/inspector")
public class InspectorCabinetController {
    @Autowired
    public ReportRepository reportRepository;
    @Autowired
    private ReportService reportService;

/*    @PostMapping("/show")
    public String postShowPage(Model model){
        Iterable<Report> reports = reportRepository.findAll();
        model.addAttribute("reports", reports);
        return "inspector.cabinet.show";
    }*/

    @GetMapping("/show")
    public String getShowPage(Model model){
        Iterable<Report> reports = reportRepository.findAll();
        model.addAttribute("reports", reports);
        return "inspector.cabinet.show";
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

        Iterable<Report> reports = reportRepository.findAllByEmailAndStatus(email, status);
        model.addAttribute("reports", reports);
        return "inspector.cabinet.show";
    }
}
