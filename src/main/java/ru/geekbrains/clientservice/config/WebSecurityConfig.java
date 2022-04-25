package ru.geekbrains.clientservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 21.04.2022
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "select client_name, client_password, enabled from shorty_video_service.client where client_name = ?"
                )
                .authoritiesByUsernameQuery(
                        "select client_name, role_name from shorty_video_service.client left join shorty_video_service.client_role cr on cr.role_id = client.role_id where client_name = ?"
                );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/new_client").permitAll()
                .antMatchers("/api/welcome").hasRole("USER")
                .and().formLogin();
    }

//    @Bean
//    UserDetailsService clients(DataSource dataSource) {
//        UserDetails client = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$10$wtEv4ZBwp13X4eelTwTzrORABaxoU19VMNTLweviOVkH6XMPN91gm")
//                .roles("USER")
//                .build();
//        JdbcUserDetailsManager clientJdbc = new JdbcUserDetailsManager(dataSource);
//        clientJdbc.createUser(client);
//        return clientJdbc;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
