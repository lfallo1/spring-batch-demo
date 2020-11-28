package com.lancefallon.springbatchhelloworld.writer;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value="orderWriter")
public class OrderItemWriter extends AbstractItemStreamItemWriter<Double> {
    @Override
    public void write(List<? extends Double> list) throws Exception {
        System.out.println("OrderItemWriter: " + list);
    }
}
