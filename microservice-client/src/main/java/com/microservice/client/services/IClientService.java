package com.microservice.client.services;

import com.microservice.client.entities.Client;
import com.microservice.client.http.response.OrdersByClientResponse;

import java.util.List;

public interface IClientService {

    List<Client> findAll();

    Client findById(Long id);

    void save (Client client);

    OrdersByClientResponse findOrdersByIdClient(Long idClient);
}
