package ru.geekbrains.clientservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientByClientName(String name) {
        return clientRepository.findByClientName(name);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> saveClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client getClientByName(String clientName) {
        return clientRepository.findByClientName(clientName);
    }

    public Client getClientBySecondName(String clientSecondName) {
        return clientRepository.findByClientSecondName(clientSecondName);
    }

    public String deleteClient(long id) {
        clientRepository.deleteById(id);
        return "Client removed! " + id;
    }

    public Client updateClient(Client client) {
        Client existingClient = clientRepository.findById(client.getClientId()).orElse(null);

        existingClient.setClientName(client.getClientName());
        existingClient.setClientSecondName(client.getClientSecondName());
        existingClient.setAge(client.getAge());
        existingClient.setClientPassword(client.getClientPassword());
        existingClient.setSex(client.isSex());

        return clientRepository.save(existingClient);
    }

}

