package com.microservice.client.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO { // Representación del entity del microservicio de Order
    private String name;

    private Double price;

    private String clientId;
}
