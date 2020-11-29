package com.lancefallon.springbatchhelloworld.config.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJobExecutionListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("BeforeJob (instance)::" + jobExecution.getJobInstance().getJobName());
        jobExecution.getExecutionContext().put("name", "Lance");
        System.out.println("BeforeJob (execution context)::" + jobExecution.getExecutionContext().toString());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
