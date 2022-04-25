package ru.geekbrains.clientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entity.Client;
import ru.geekbrains.clientservice.exceptions.ClientNotFoundException;
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

    public Client findByClientName(String name){
        return clientRepo.findByClientName(name);
    }

    public Client updateClient(Client client) {
        Client existingClient = clientRepo.findById(client.getClientId()).orElse(null);

        if (existingClient != null) {
            existingClient.setClientName(client.getClientName());
            existingClient.setClientSecondName(client.getClientSecondName());
            existingClient.setAge(client.getAge());
            existingClient.setClientPassword(client.getClientPassword());
            existingClient.setSex(client.isSex());
        }

        throw new ClientNotFoundException("This user does not exist!");
    }

}

