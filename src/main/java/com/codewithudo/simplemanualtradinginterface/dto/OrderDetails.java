package com.codewithudo.simplemanualtradinginterface.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderDetails {

    private String id;
    private String side;
    private String state;
    private String market;

    @JsonProperty("ord_type")
    private String orderType;

    private BigDecimal price;

    @JsonProperty("avg_price")
    private BigDecimal averagePrice;

    private BigDecimal volume;

    @JsonProperty("remaining_volume")
    private BigDecimal remainingVolume;

    @JsonProperty("executed_volume")
    private BigDecimal executedVolume;

    @JsonProperty("created_at")
    private String createdAt;
}