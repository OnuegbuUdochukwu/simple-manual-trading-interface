package com.codewithudo.simplemanualtradinginterface.service;

import com.codewithudo.simplemanualtradinginterface.dto.CreateOrderRequest;
import com.codewithudo.simplemanualtradinginterface.dto.OrderDetails;
import com.codewithudo.simplemanualtradinginterface.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class TradingService {

    private final RestTemplate restTemplate;

    @Value("${quidax.api.secret-key}")
    private String secretKey;

    public TradingService() {
        this.restTemplate = new RestTemplate();
    }

    public OrderDetails placeOrder(CreateOrderRequest request) {
        String url = "https://app.quidax.io/api/v1/users/me/orders";

        // Create the authentication headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secretKey);

        // 1. Create the request body to send to Quidax
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("market", request.getMarket());
        requestBody.put("side", request.getSide());
        requestBody.put("ord_type", "market"); // We are placing a market order
        requestBody.put("volume", request.getQuantity());

        // 2. Create an HttpEntity that includes the body and headers
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // 3. Execute the POST request
        OrderResponse response = restTemplate.postForObject(url, entity, OrderResponse.class);

        // Unwrap and return the order details
        if (response != null && "success".equals(response.getStatus())) {
            return response.getData();
        }

        return null;
    }
}