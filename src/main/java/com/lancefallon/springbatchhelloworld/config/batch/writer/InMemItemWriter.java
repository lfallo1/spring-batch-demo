package com.lancefallon.springbatchhelloworld.config.batch.writer;

import com.lancefallon.springbatchhelloworld.domain.Product;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "memoryWriter")
public class InMemItemWriter extends AbstractItemStreamItemWriter<Product> {
    @Override
    public void write(List<? extends Product> list) throws Exception {
        System.out.println("in memory writer: " + list);
    }
}
