package com.lancefallon.springbatchhelloworld.writer;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "consoleWriter")
public class ConsoleItemWriter extends AbstractItemStreamItemWriter {
    @Override
    public void write(List list) throws Exception {
        System.out.println("*************** writing each chunk *************");
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
