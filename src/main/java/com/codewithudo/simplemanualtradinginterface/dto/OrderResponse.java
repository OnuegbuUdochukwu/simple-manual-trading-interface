package com.codewithudo.simplemanualtradinginterface.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private String status;
    private OrderDetails data;
}