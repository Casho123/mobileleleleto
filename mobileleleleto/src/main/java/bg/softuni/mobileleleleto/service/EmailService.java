package bg.softuni.mobileleleleto.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class EmailService {

    private final TemplateEngine templateEngine;

    public EmailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void sendRegistrationEmail(String userEmail,
                                      String userName) {
    }
}
