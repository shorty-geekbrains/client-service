package ru.geekbrains.clientservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.geekbrains.clientservice.entities.Client;
import ru.geekbrains.clientservice.repository.ClientRepo;
import ru.geekbrains.clientservice.utils.PasswordAndUsernameValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 06.05.2022
 */
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepo clientRepo;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private PasswordAndUsernameValidator passwordValidator;
    private ClientService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ClientService(clientRepo, passwordEncoder, passwordValidator);
    }

    @Test
    void saveClient() {
        given(passwordValidator.IsValid(anyString())).willReturn(true);
        given(passwordEncoder.encode(anyString())).willReturn("1111");

        Client client = new Client();
        client.setName("bob");
        client.setSecond_name("marley");
        client.setPassword("1111");
        client.setEnabled(true);
        client.setAge("2020-10-02");
        client.setSex(true);
        client.setPhoto("asd");
        client.setRole_id(2);

        underTest.saveClient(client);

        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepo).save(clientArgumentCaptor.capture());
        Client capturedClient = clientArgumentCaptor.getValue();
        assertThat(capturedClient).isEqualTo(client);

    }

    @Test
    void findClientByClientName() {
        String name = "bob";
        given(clientRepo.findByName(name)).willReturn(new Client());
        underTest.findClientByClientName(name);
        verify(clientRepo).findByName(name);

    }
}