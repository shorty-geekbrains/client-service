package ru.geekbrains.clientservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.repository.ClientRepo;
import ru.geekbrains.clientservice.utils.PasswordAndUsernameValidator;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;
    private final PasswordAndUsernameValidator passwordValidator;
    Client newClient = new Client();


    public boolean saveClient(Client client) {
        if (findClientByClientName(client.getClientName()) != null) {
            throw new IllegalArgumentException("Client is already registered");
        }
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
        newClient.setSex(client.isSex());
        newClient.setClientPhoto("asd");
        newClient.setRoleId(client.getRoleId());
//        вынести в DTO

        clientRepo.save(newClient);
        return true;
    }

    public Client findClientByClientName(String name) {
        return clientRepo.findByClientName(name);
    }


}

