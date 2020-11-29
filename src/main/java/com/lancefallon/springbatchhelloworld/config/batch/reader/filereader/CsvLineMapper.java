package com.lancefallon.springbatchhelloworld.config.batch.reader.filereader;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class CsvLineMapper {

    private Class type;
    private String delimiter;
    private String[] fields;

    public CsvLineMapper(Class type, String delimiter, String[] fields){
        this.type = type;
        this.delimiter = delimiter;
        this.fields = fields;
    }

    public LineMapper build() {
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        lineMapper.setLineTokenizer(delimittedTokenizer(delimiter, fields));
        lineMapper.setFieldSetMapper(fieldMapper());
        return lineMapper;
    }

    public LineTokenizer delimittedTokenizer(String delimiter, String[] fields) {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(delimiter);
        tokenizer.setNames(fields);
        return tokenizer;
    }

    public FieldSetMapper fieldMapper() {
        BeanWrapperFieldSetMapper mapper = new BeanWrapperFieldSetMapper();
        mapper.setTargetType(type);
        return mapper;
    }

}
