package ru.geekbrains.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.clientservice.entities.Client;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */
public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findByClientName(String name);


}
