package ru.geekbrains.clientservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.geekbrains.clientservice.entities.Client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 11.05.2022
 */
@DataJpaTest
class ClientRepoTest {

    @Autowired
    private ClientRepo repo;

    @Test
    void findByName() {
        String password = "1234567Az+";
        Client client = new Client();
        client.setName("bob");
        client.setSecondName("marley");
        client.setConfPassword(password);
        client.setPassword(password);
        client.setEnabled(true);
        client.setAge("2020-10-02");
        client.setSex(true);
        client.setPhoto("asd");
        client.setRoleId(2);

        repo.save(client);

        assertNotNull(repo.findByName("bob"));
    }
}