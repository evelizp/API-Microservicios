package com.microservice.client.feignClient;

import com.microservice.client.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/* Esta interfaz Feign proporciona una forma declarativa de definir cómo se realizan las
 * llamadas al microservicio de órdenes desde el microservicio de clientes */

@FeignClient(name = "msvc-order", url = "localhost:8080/api/order")
public interface OrderFeignClient {

    @GetMapping("/search-by-client/{idClient}")
    List<OrderDTO> findAllOrdersByClient(@PathVariable Long idClient);
}
