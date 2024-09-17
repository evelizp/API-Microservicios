package com.microservice.order.services;

import com.microservice.order.entities.Order;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();

    Order findById(Long id);

    void save (Order order);

    List<Order> findByIdClient(Long idClient);
}
