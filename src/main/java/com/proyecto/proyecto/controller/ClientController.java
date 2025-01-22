package com.proyecto.proyecto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.proyecto.model.Client;
import com.proyecto.proyecto.service.client.ClientServiceImpl;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    public ClientController (ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.ok(clientServiceImpl.findAllClient());
    }

    @PostMapping("/client/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client Client) {
        try {
            Client saveClient = clientServiceImpl.saveClient(Client);
            return ResponseEntity.created(new URI("/api/client/" + saveClient.getId())).body(saveClient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/client/delete/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable("id") Long id_client){
        return ResponseEntity.ok(clientServiceImpl.deleteClientById(id_client));
    }

}
