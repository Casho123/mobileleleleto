package bg.softuni.mobileleleleto.web;

import bg.softuni.mobileleleleto.models.dto.UserRegistrationDTO;
import bg.softuni.mobileleleleto.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initUserReg() {
        return new UserRegistrationDTO();

    }


    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/users/register";
        }

        this.userService.registerAndLogin(userRegistrationDTO);
        return "redirect:/";

    }
}
