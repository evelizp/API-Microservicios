package com.microservice.client.controllers;

import com.microservice.client.entities.Client;
import com.microservice.client.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void saveClient(@RequestBody Client client) {
        clientService.save(client);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllClients () {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping("/search-order/{idClient}")
    public ResponseEntity<?> findOrdersByIdClient (@PathVariable Long idClient) {
        return ResponseEntity.ok(clientService.findOrdersByIdClient(idClient));
    }
}