package bg.softuni.mobileleleleto.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.validation.Valid;

@Controller
public class UserController {


    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }




}
