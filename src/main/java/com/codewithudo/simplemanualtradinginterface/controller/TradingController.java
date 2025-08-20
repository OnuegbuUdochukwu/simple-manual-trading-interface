package com.codewithudo.simplemanualtradinginterface.controller;

import com.codewithudo.simplemanualtradinginterface.dto.CreateOrderRequest;
import com.codewithudo.simplemanualtradinginterface.dto.OrderDetails;
import com.codewithudo.simplemanualtradinginterface.service.TradingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TradingController {

    private final TradingService tradingService;

    public TradingController(TradingService tradingService) {
        this.tradingService = tradingService;
    }

    @PostMapping("/orders")
    public OrderDetails placeOrder(@RequestBody CreateOrderRequest request) {
        return tradingService.placeOrder(request);
    }
}
