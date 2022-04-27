package ru.geekbrains.clientservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.clientservice.utils.PasswordAndUsernameValidator;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 25.04.2022
 */
@Configuration
public class AuthValidator {

    @Bean
    public PasswordAndUsernameValidator getValidator() {
        return new PasswordAndUsernameValidator();
    }
}
