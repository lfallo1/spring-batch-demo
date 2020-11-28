package com.lancefallon.springbatchhelloworld.writer;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "memoryWriter")
public class InMemItemWriter extends AbstractItemStreamItemWriter<Integer> {
    @Override
    public void write(List<? extends Integer> list) throws Exception {
        System.out.println("in memory writer: " + list);
    }
}
