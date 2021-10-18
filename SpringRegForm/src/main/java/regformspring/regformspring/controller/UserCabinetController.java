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
import regformspring.regformspring.model.Type;
import regformspring.regformspring.model.User;
import regformspring.regformspring.repository.UserRepository;
import regformspring.regformspring.security.ReportService;
import regformspring.regformspring.security.UserDetailsServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cabinet/user")
public class UserCabinetController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private ReportService reportService;

    @PostMapping("/createRep")
    public String create(@RequestParam String description, @RequestParam String type){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userDetailsService.findByEmail(auth.getName());

        Report report = new Report(description, Type.valueOf(type));
        report.setAuthor(user.get().getFirstName(), user.get().getLastName());
        report.setEmail(user.get().getEmail());
        reportService.save(report);
        return "redirect:/cabinet/user/create";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        return findPaginatedByEmail(1, model);
    }

    @GetMapping("/change/{id}")
    public String change(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("report", reportService.getReportById(id));
        return "user.unapprove";
    }

    @PostMapping("/saveReport")
    public String saveReport(@RequestParam Long id,@RequestParam String description){

        reportService.sentById(id);
        reportService.changeDescriptionById(id, description);
        return "redirect:/cabinet/user/create";
    }

    @GetMapping("/filter/{status}")
    public String filter(@PathVariable(value = "status") ReportStatus status, Model model){
        return findPaginatedByEmailAndStatus( status,1, model);
    }

    @GetMapping("/create/{pageNumber}")
    public String findPaginatedByEmail(@PathVariable(value = "pageNumber") int pageNumber, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userDetailsService.findByEmail(auth.getName());
        int pageSize = 4;

        Page<Report> page = reportService.findPaginatedByEmail(pageNumber, pageSize, user.get().getEmail());
        List<Report> reports = page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("reports", reports);
        model.addAttribute("status", ReportStatus.UNAPPROVED);

        return "user.cabinet.create";
    }

    @GetMapping("/filter/{pageNumber}/{status}")
    public String findPaginatedByEmailAndStatus(@PathVariable(value = "status") ReportStatus status, @PathVariable(value = "pageNumber") int pageNumber, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userDetailsService.findByEmail(auth.getName());
        int pageSize = 4;

        Page<Report> page = reportService.findPaginatedByEmailAndStatus(pageNumber, pageSize, user.get().getEmail(), status);
        List<Report> reports = page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("status", status);
        model.addAttribute("statusUNAPPROVED", ReportStatus.UNAPPROVED);
        model.addAttribute("reports", reports);

        return "user.cabinet.filter";
    }
}