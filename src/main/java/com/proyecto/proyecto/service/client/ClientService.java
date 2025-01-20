package com.proyecto.proyecto.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Client;


@Service
public interface ClientService {
    List<Client> findAllClient();

    void deleteClient(Client client);

    void deleteClientById(Long id_persona);

    Client saveClient(Client client);

    Optional <Client> findClientById(Long id_client);

    Page<Client> findAll(Pageable pageable);

    List<Client> findAll(Sort sort);
}
