package com.microservice.client.services;

import com.microservice.client.dto.OrderDTO;
import com.microservice.client.entities.Client;
import com.microservice.client.feignClient.OrderFeignClient;
import com.microservice.client.http.response.OrdersByClientResponse;
import com.microservice.client.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public OrdersByClientResponse findOrdersByIdClient(Long idClient) {

        // Consultar el cliente
        Client client = clientRepository.findById(idClient).orElse(new Client());

        // Obtener los pedidos de un cliente usando su id que viene del microservicio de orders
        List<OrderDTO> orderDTOList = orderFeignClient.findAllOrdersByClient(idClient);

        return OrdersByClientResponse.builder()
                .clientName(client.getName())
                .lastName(client.getLastname())
                .orderDTOList(orderDTOList)
                .build();
    }
}
