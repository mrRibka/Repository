package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.ReportStatus;
import regformspring.regformspring.model.Type;
import regformspring.regformspring.model.User;
import regformspring.regformspring.repository.ReportRepository;
import regformspring.regformspring.repository.UserRepository;
import regformspring.regformspring.security.ReportService;

import java.util.Optional;

@Controller
@RequestMapping("/cabinet/user")
public class UserCabinetController {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReportService reportService;

    @PostMapping("/create")
    public String postCreatePage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());

        Iterable<Report> reports = reportRepository.findAllByEmail(user.get().getEmail());
        model.addAttribute("reports", reports);
        return "user.cabinet.create";
    }

    @PostMapping("/createRep")
    public String create(@RequestParam String description, @RequestParam String type){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());
        Report report = new Report(description, Type.valueOf(type));
        report.setAuthor(user.get().getFirstName(), user.get().getLastName());
        report.setEmail(user.get().getEmail());
        reportRepository.save(report);
        return "user.cabinet";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());

        Iterable<Report> reports = reportRepository.findAllByEmail(user.get().getEmail());
        model.addAttribute("reports", reports);
        return "user.cabinet.create";
    }

    @GetMapping("/change/{id}")
    public String change(@PathVariable(value = "id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());
        if (reportService.getReportById(id).getStatus() == ReportStatus.UNAPPROVED){
            model.addAttribute("report", reportService.getReportById(id));
            return "user.unapprove";
        }

        Iterable<Report> reports = reportRepository.findAllByEmail(user.get().getEmail());
        model.addAttribute("reports", reports);
        return "redirect:/cabinet/user/create";
    }

    @PostMapping("/saveReport")
    public String saveReport(@RequestParam Long id,@RequestParam String description){

        reportService.saveReport(reportService.sentById(id));
        reportService.saveReport(reportService.changeDescriptionById(id, description));
        return "redirect:/cabinet/user/create";
    }

    @GetMapping("/filter/{status}")
    public String filter(@PathVariable(value = "status") ReportStatus status, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());

        Iterable<Report> reports = reportRepository.findAllByEmailAndStatus(user.get().getEmail(), status);
        model.addAttribute("reports", reports);
        return "user.cabinet.create";
    }
}