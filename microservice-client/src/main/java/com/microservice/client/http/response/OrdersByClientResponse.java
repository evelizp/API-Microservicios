package com.microservice.client.http.response;

import com.microservice.client.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersByClientResponse {

    private String clientName;
    private String lastName;
    private List<OrderDTO> orderDTOList;
}
