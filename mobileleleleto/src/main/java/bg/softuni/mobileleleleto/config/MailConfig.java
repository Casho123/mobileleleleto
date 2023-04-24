package bg.softuni.mobileleleleto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {


    @Bean
    public JavaMailSender javaMailSender() {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost();
        javaMailSender.setPort();
        javaMailSender.setUsername();
        javaMailSender.setPassword();
        javaMailSender.setJavaMailProperties();

        return javaMailSender;

    }
}
