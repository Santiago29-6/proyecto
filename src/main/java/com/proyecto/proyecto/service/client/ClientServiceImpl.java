package com.proyecto.proyecto.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Client;
import com.proyecto.proyecto.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void deleteClientById(Long id_client) {
        clientRepository.deleteById(id_client);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findClientById(Long id_client) {
        return clientRepository.findById(id_client);
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public List<Client> findAll(Sort sort){
        return clientRepository.findAll(sort);
    }
}
