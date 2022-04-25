package ru.geekbrains.clientservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.services.ClientService;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;


    @PostMapping("/new_client")
    public void addClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}

