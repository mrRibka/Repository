package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import regformspring.regformspring.model.Report;
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
    private UserRepository userRepository;
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
        reportService.approveById(id);
        return "redirect:/cabinet/inspector/show";
    }
}
