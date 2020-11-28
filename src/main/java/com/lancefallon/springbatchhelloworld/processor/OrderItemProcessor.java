package com.lancefallon.springbatchhelloworld.processor;

import com.lancefallon.springbatchhelloworld.domain.Order;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component(value="orderProcessor")
public class OrderItemProcessor implements ItemProcessor<Order, Double> {
    @Override
    public Double process(Order order) throws Exception {
        return order.getOrderTotal() * 0.25;
    }
}
