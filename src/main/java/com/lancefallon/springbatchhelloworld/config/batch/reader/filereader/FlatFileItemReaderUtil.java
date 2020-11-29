package com.lancefallon.springbatchhelloworld.config.batch.reader.filereader;

import com.lancefallon.springbatchhelloworld.config.batch.reader.filereader.mapper.CsvLineMapper;
import com.lancefallon.springbatchhelloworld.domain.Product;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class FlatFileItemReaderUtil {

    @Value("${batch.file.product.csv}")
    private String productCsv;

    @Value("${batch.file.product.xml}")
    private String productXml;

    @Bean
    public FlatFileItemReader productCsvFileItemReader() {
        String[] fields = new String[]{"productID", "productName", "productDesc", "price", "unit"};
        FlatFileItemReader reader = new FlatFileItemReader();
        reader.setResource(new ClassPathResource(productCsv));
        reader.setLineMapper(new CsvLineMapper(Product.class, DelimitedLineTokenizer.DELIMITER_COMMA, fields).build());
        reader.setLinesToSkip(1);
        return reader;
    }

    @Bean
    public StaxEventItemReader productXmlFileItemReader() {
        StaxEventItemReader reader = new StaxEventItemReader();
        reader.setResource(new ClassPathResource(productXml));
        reader.setFragmentRootElementName("product");
        reader.setUnmarshaller(new Jaxb2Marshaller() {
            {
                setClassesToBeBound(Product.class);
            }
        });
        return reader;
    }

}
