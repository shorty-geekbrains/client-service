package ru.geekbrains.clientservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.services.ClientService;

import javax.annotation.security.RolesAllowed;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/registration")
    public ModelAndView addClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return new ModelAndView("sign-up");
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("sign-in");
    }

    @PostMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("sign-in");
    }

//    @GetMapping("/test")
//    public String test() {
//        return "testt";
//    }
}

