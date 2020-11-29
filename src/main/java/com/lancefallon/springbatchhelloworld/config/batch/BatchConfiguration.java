package com.lancefallon.springbatchhelloworld.config.batch;

import com.lancefallon.springbatchhelloworld.config.batch.reader.filereader.FlatFileItemReaderUtil;
import com.lancefallon.springbatchhelloworld.domain.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    /* Listeners */
    @Autowired
    private JobExecutionListener jobExecutionListener;

    @Autowired
    private StepExecutionListener stepExecutionListener;

    /* item readers/processors/writers */
    @Autowired
    private FlatFileItemReaderUtil flatFileItemReaderUtil;

    @Autowired
    private ItemProcessor itemProcessor;

    @Autowired
    private ItemWriter itemWriter;


    /* Steps */
    @Bean
    public Step step1() {
        return steps.get("step1")
                .<Product, Product>chunk(1)
//                .reader(flatFileItemReaderUtil.productXmlFileItemReader())
                .reader(flatFileItemReaderUtil.productCsvFileItemReader())
                .writer(itemWriter)
                .build();
    }

    /* Jobs */
    @Bean
    public Job helloWorldJob() {
        return jobs.get("productReader")
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener)
                .start(step1())
                .build();
    }

}
