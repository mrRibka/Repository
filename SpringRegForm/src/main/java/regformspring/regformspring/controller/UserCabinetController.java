package regformspring.regformspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cabinet/user")
public class UserCabinetController {
    @GetMapping
    public String getPage(){
        return "user.cabinet";
    }
}