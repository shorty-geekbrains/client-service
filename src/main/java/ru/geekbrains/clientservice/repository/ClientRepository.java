package ru.geekbrains.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.clientservice.entities.Client;

import java.util.List;
import java.util.Optional;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 19.04.2022
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Override
    <S extends Client> S save(S entity);

    @Override
    Optional<Client> findById(Long aLong);

    @Override
    List<Client> findAll();

    @Override
    void deleteById(Long aLong);

    Client findByClientName(String clientName);

    Client findByClientSecondName(String clientSecondName);
}
