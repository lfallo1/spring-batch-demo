package com.lancefallon.springbatchhelloworld.config.batch.reader.filereader.mapper;

import com.lancefallon.springbatchhelloworld.domain.Product;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class ProductCsvLineMapper {

    public LineMapper lineMapper() {
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        lineMapper.setLineTokenizer(delimittedTokenizer());
        lineMapper.setFieldSetMapper(fieldMapper());
        return lineMapper;
    }

    public LineTokenizer delimittedTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(DelimitedLineTokenizer.DELIMITER_COMMA);
        tokenizer.setNames(new String[]{"productID", "productName", "productDesc", "price", "unit"});
        return tokenizer;
    }

    public FieldSetMapper fieldMapper() {
        BeanWrapperFieldSetMapper mapper = new BeanWrapperFieldSetMapper();
        mapper.setTargetType(Product.class);
        return mapper;
    }

}
