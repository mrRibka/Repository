package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import regformspring.regformspring.model.Role;
import regformspring.regformspring.model.Status;
import regformspring.regformspring.model.User;
import regformspring.regformspring.repository.UserRepository;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam String username,@RequestParam String first_name, @RequestParam String last_name, @RequestParam String password){
        User user = new User(username, password, first_name, last_name);
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/auth/login";
    }
}
