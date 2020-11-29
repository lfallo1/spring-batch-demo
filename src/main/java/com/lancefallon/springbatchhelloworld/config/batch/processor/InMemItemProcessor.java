package com.lancefallon.springbatchhelloworld.config.batch.processor;

import com.lancefallon.springbatchhelloworld.domain.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class InMemItemProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product item) throws Exception {
        return item;
    }
}
