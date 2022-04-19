package ru.geekbrains.clientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entity.Client;
import ru.geekbrains.clientservice.repository.ClientRepo;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    public Client findClientByClientName(String name) {
        return clientRepo.findByClientName(name);
    }

}

