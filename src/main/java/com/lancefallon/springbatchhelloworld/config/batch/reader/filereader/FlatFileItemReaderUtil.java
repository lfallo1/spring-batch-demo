package com.lancefallon.springbatchhelloworld.config.batch.reader.filereader;

import com.lancefallon.springbatchhelloworld.config.batch.reader.filereader.mapper.ProductLineMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class FlatFileItemReaderUtil {

    @Value("${batch.file.product}")
    private String fileName;

    @Bean
    public FlatFileItemReader orderFlatFileItemReader() {
        FlatFileItemReader reader = new FlatFileItemReader();
        reader.setResource(new ClassPathResource(fileName));
        reader.setLineMapper(new ProductLineMapper().lineMapper());
        reader.setLinesToSkip(1);
        return reader;
    }

}
