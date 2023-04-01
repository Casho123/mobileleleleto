package bg.softuni.mobileleleleto.web;

import bg.softuni.mobileleleleto.models.dto.UserLoginDTO;
import bg.softuni.mobileleleleto.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDTO userLoginDTO) {
        System.out.println("User is logged: " + userService.login(userLoginDTO));

        return "redirect:/";



    }
}
