package com.codewithudo.simplemanualtradinginterface.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String market;
    private String side;
    private String quantity;
}