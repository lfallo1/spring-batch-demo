package com.lancefallon.springbatchhelloworld.reader;

import com.lancefallon.springbatchhelloworld.domain.Order;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component(value = "orderReader")
public class OrderItemReader extends FlatFileItemReader<Order> {

    private int idx = 0;

    public OrderItemReader() {
        this.setResource(new ClassPathResource("data/orders.csv"));
        this.setLinesToSkip(1);
        this.setLineMapper(createOrderLineMapper());
    }

    private LineMapper<Order> createOrderLineMapper() {
        DefaultLineMapper<Order> orderLineMapper = new DefaultLineMapper<>();

        LineTokenizer orderLineTokenizer = createOrderLineTokenizer();
        orderLineMapper.setLineTokenizer(orderLineTokenizer);

        FieldSetMapper<Order> orderInformationMapper = orderInformationMapper();
        orderLineMapper.setFieldSetMapper(orderInformationMapper);

        return orderLineMapper;
    }

    private LineTokenizer createOrderLineTokenizer() {
        DelimitedLineTokenizer orderLineTokenizer = new DelimitedLineTokenizer();
        orderLineTokenizer.setDelimiter(",");
        orderLineTokenizer.setNames(new String[]{
                "orderId",
                "orderTotal",
                "orderTimestamp"
        });
        return orderLineTokenizer;
    }

    private FieldSetMapper<Order> orderInformationMapper() {
        BeanWrapperFieldSetMapper<Order> orderInformationMapper = new BeanWrapperFieldSetMapper<>();
        orderInformationMapper.setTargetType(Order.class);
        return orderInformationMapper;
    }

    @Override
    public Order read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return super.read();
    }
}

