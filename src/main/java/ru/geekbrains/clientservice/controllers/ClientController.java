package ru.geekbrains.clientservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.services.ClientService;

import java.util.List;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

//@Controller
//@RequestMapping("/api")
@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(
            value = {"/clients"},
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
        return "redirect:/api/clients";
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PostMapping("/addClients")
    public List<Client> addClient(@RequestBody List<Client> clients) {
        return clientService.saveClients(clients);
    }

    @GetMapping("/clients")
    public List<Client> findAllClients() {
        return clientService.getClients();
    }

    @GetMapping("/clientById/{id}")
    public Client findClientById(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/client/{name}")
    public Client findClientByName(@PathVariable String name) {
        return clientService.getClientByName(name);
    }

    @GetMapping("/client/{secondName}")
    public Client findClientBySecondName(@PathVariable String secondName) {
        return clientService.getClientBySecondName(secondName);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable long id) {
        return clientService.deleteClient(id);
    }

}

