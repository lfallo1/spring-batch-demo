package com.lancefallon.springbatchhelloworld.config;

import com.lancefallon.springbatchhelloworld.tasklet.MyTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("orderReader")
    private ItemReader itemReader;

    @Autowired
    @Qualifier("orderProcessor")
    private ItemProcessor itemProcessor;

    @Autowired
    @Qualifier("orderWriter")
    private ItemWriter itemWriter;


    /* Steps */
    @Bean
    public Step step1() {
        return steps.get("step1")
                .listener(stepExecutionListener)
                .tasklet(getMyTasklet())
                .build();
    }

    @Bean
    public Step step2() {
        return steps.get("step2")
                .<Integer, Integer>chunk(2)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    /* Jobs */
    @Bean
    public Job helloWorldJob() {
//        return jobs.get("helloWorldJob")
//                .listener(jobExecutionListener)
//                .start(step1())
//                .next(step2())
//                .build();

        return jobs.get("helloWorldJob")
                .listener(jobExecutionListener)
                .start(step2())
                .build();
    }

    /* Tasklets */
    @Bean
    public Tasklet getMyTasklet() {
        return new MyTasklet();
    }

}
