package com.example.activity.infrastructure.client.service.order;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-service" , url = "http://127.0.0.1:8082/order")
public interface OrderApiClient {
}
