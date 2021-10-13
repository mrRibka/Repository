package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import regformspring.regformspring.model.Report;
import regformspring.regformspring.model.User;
import regformspring.regformspring.repository.ReportRepository;
import regformspring.regformspring.repository.UserRepository;

import java.util.Optional;

@Controller
@RequestMapping("/cabinet/user")
public class UserCabinetController {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getPage(){
        return "user.cabinet";
    }

    @PostMapping("/create")
    public String getCreatePage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());

        Iterable<Report> reports = reportRepository.findAllByEmail(user.get().getEmail());
        model.addAttribute("reports", reports);
        return "user.cabinet.create";
    }

    @PostMapping("/createRep")
    public String create(@RequestParam String description){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());
        Report report = new Report(description);
        report.setAuthor(user.get().getFirstName(), user.get().getLastName());
        report.setEmail(user.get().getEmail());
        reportRepository.save(report);
        return "user.cabinet";
    }
}