package ru.geekbrains.clientservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.geekbrains.clientservice.entities.Client;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 11.05.2022
 */
@DataJpaTest
@AutoConfigureTestDatabase
class ClientRepoTest {

    @Autowired
    private ClientRepo repo;

    @Test
    void findByName() {
        String password = "1234567Az+";
        Client client = new Client();
        client.setName("bob");
        client.setSecond_name("marley");
        client.setConfPassword(password);
        client.setPassword(password);
        client.setEnabled(true);
        client.setAge("10.04.2020");
        client.setSex(true);
        client.setPhoto("asd");
        client.setRole_id(2);

        repo.save(client);

        assertNotNull(repo.findByName("bob"));
    }
}