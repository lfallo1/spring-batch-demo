package com.lancefallon.springbatchhelloworld.domain;

import java.time.LocalDate;

public class Order {
    private Long orderId;
    private Double orderTotal;
    private Long orderTimestamp;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Long getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Long orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }
}
