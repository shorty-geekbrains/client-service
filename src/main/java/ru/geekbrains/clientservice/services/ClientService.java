package ru.geekbrains.clientservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.exceptions.ClientNotFoundException;
import ru.geekbrains.clientservice.repository.ClientRepo;
import ru.geekbrains.clientservice.utils.PasswordAndUsernameValidator;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;
    private final PasswordAndUsernameValidator passwordValidator;


    public void saveClient(Client client) {
        Client newClient = new Client();
        if (findClientByClientName(client.getName()) != null) {
            throw new IllegalArgumentException("Client is already registered");
        }
        if (!passwordValidator.IsValid(client.getPassword())) {
            throw new IllegalArgumentException("Password isn't valid");
        }
        if (nonNull(client.getConfPassword())&&!client.getConfPassword().equals(client.getPassword())) {
            throw new IllegalArgumentException("Passwords must be identity");
        } else {
            newClient.setPassword(passwordEncoder.encode(client.getPassword()));
        }
        newClient.setName(client.getName());
        newClient.setSecondName(client.getSecondName());
        newClient.setEnabled(true);
        newClient.setAge(client.getAge());
        newClient.setSex(client.isSex());
        newClient.setPhoto("asd");
        newClient.setRoleId(2);

        clientRepo.save(newClient);
    }

    public Client findClientByClientName(String name) {
        return clientRepo.findByName(name);
    }

    public Client updateClient(Client client) {
        Client existingClient = clientRepo.findById(client.getId()).orElse(null);

        if (existingClient == null) {
            throw new ClientNotFoundException("This user does not exist!");
        }
        existingClient.setName(client.getName());
        existingClient.setSecondName(client.getSecondName());
        existingClient.setAge(client.getAge());
        existingClient.setPassword(client.getPassword());
        existingClient.setSex(client.isSex());

        return clientRepo.save(existingClient);
    }

}

