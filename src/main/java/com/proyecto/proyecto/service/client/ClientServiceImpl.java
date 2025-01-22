package com.proyecto.proyecto.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.exception.NotFoundException;
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
    public boolean deleteClientById(Long id_client) {
        if (findClientById(id_client).isPresent()) {
            clientRepository.deleteById(id_client);
            return true;
        }
        return false;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findClientById(Long id_client) {
        Optional<Client> client = clientRepository.findById(id_client);
        if (client.isPresent()){
            throw new NotFoundException("No se ha encontrado un cliente con ese id: " + id_client);
        }

        return client;
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
