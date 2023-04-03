package bg.softuni.mobileleleleto.web;

import bg.softuni.mobileleleleto.models.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {


    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {

        return "redirect:/";

    }


}
