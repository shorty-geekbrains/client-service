package ru.geekbrains.clientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.clientservice.entity.Client;
import ru.geekbrains.clientservice.service.ClientService;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@Controller
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(
            value = {"/users"},
            method = {RequestMethod.GET})
    public ModelAndView findAll(Model model) {
        model.addAttribute("clients", this.clientService.findAllClients());
        return new ModelAndView("index");
    }

    @GetMapping({"/registration"})
    public String registration(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "registration";
    }

    @PostMapping({"/registration"})
    public String registration(String clientName, Integer roleId, String clientSecondName,
                               int age, boolean sex, String clientPassword, String confPassword,
                               String clientPhoto, Model model) {
        if (!confPassword.equals(clientPassword)) {
            System.out.println("Passwords do not match");
            return "redirect:/api/registration";
        } else if (clientService.findClientByClientName(clientName) != null) {
            System.out.println("Client is registered already");
            return "redirect:/api/registration";
        } else {
            Client client = new Client(clientName, 2, clientSecondName, age, false, clientPassword,
                    confPassword, "photo");
            this.clientService.saveClient(client);
        }
        return "redirect:/api/users";
    }
}

