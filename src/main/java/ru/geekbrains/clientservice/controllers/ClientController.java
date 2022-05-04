package ru.geekbrains.clientservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.services.ClientService;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
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

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @GetMapping("/client")
    public Client findClientByClientName(@RequestParam("clientName") String clientName){
        return clientService.findClientByClientName(clientName);
    }

}
