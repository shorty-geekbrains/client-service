package ru.geekbrains.clientservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.exceptions.ClientNotFoundException;
import ru.geekbrains.clientservice.repository.ClientRepo;
import ru.geekbrains.clientservice.utils.PasswordAndUsernameValidator;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.repository.ClientRepo;
import ru.geekbrains.clientservice.utils.PasswordAndUsernameValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;

    public boolean saveClient(Client client) {
        PasswordAndUsernameValidator passwordValidator = new PasswordAndUsernameValidator();

        if (findClientByClientName(client.getClientName()) != null) {
            throw new IllegalArgumentException("Client is already registered");
        }
        Client newClient = new Client();
        if (!passwordValidator.IsValid(client.getClientPassword())) {
            throw new IllegalArgumentException("Password isn't valid");
        }
        if (!client.getConfPassword().equals(client.getClientPassword())) {
            throw new IllegalArgumentException("Passwords must be identity");
        } else {
            newClient.setClientPassword(passwordEncoder.encode(client.getClientPassword()));
        }
        newClient.setClientName(client.getClientName());
        newClient.setClientSecondName(client.getClientSecondName());
        newClient.setEnabled(true);
        newClient.setAge(client.getAge());
        newClient.setSex(true);
        newClient.setClientPhoto("asd");
        newClient.setRoleId(client.getRoleId());

        clientRepo.save(newClient);
        return true;
    }

    public Client findClientByClientName(String name) {
        return clientRepo.findByClientName(name);
    }

    public Client updateClient(Client client) {
        Client existingClient = clientRepo.findById(client.getClientId()).orElse(null);

        if (existingClient == null) {
            throw new ClientNotFoundException("This user does not exist!");
        }
        existingClient.setClientName(client.getClientName());
        existingClient.setClientSecondName(client.getClientSecondName());
        existingClient.setAge(client.getAge());
        existingClient.setClientPassword(client.getClientPassword());
        existingClient.setSex(client.isSex());

        return clientRepo.save(existingClient);
    }

}