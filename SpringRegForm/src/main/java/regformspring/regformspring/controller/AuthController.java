package regformspring.regformspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import java.util.Optional;

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

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @GetMapping("/cabinet")
    public String getCabinetPage(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getName());
        if (user.get().getRole().equals(Role.USER)){
            return "redirect:/cabinet/user";
        }else if (user.get().getRole().equals(Role.INSPECTOR)){
            return "redirect:/cabinet/inspector";
        }
        return auth.getName();
    }

    @PostMapping("/register")
    public String addUser
            (@RequestParam String username,@RequestParam String first_name,
             @RequestParam String last_name, @RequestParam String password){

        Optional<User> userFromDb = userRepository.findByEmail(username);
        if(userFromDb != null){
            return "register";
        }
        User user = new User(username, password, first_name, last_name, Role.USER, Status.ACTIVE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/auth/login";
    }
}

