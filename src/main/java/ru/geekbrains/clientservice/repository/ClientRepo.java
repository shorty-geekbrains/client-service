package ru.geekbrains.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.clientservice.entities.Client;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */
@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findByName(String name);


}
