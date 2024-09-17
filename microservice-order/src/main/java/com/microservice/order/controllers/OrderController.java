package com.microservice.order.controllers;

import com.microservice.order.entities.Order;
import com.microservice.order.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void saveOrder(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllOrders () {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    // End-point para llamar desde el microservicio de client
    @GetMapping("/search-by-client/{idClient}")
    public ResponseEntity<?> findByIdClient(@PathVariable Long idClient) {
        return ResponseEntity.ok(orderService.findByIdClient(idClient));
    }
}
