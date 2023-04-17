package bg.softuni.mobileleleleto.web;

import bg.softuni.mobileleleleto.models.dto.UserLoginDTO;
import bg.softuni.mobileleleleto.models.dto.UserRegistrationDTO;
import bg.softuni.mobileleleleto.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {


    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }




}
