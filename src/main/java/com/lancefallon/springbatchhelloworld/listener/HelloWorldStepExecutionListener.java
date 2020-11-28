package com.lancefallon.springbatchhelloworld.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("BeforeStep (execution context -> 'name')::" + stepExecution.getJobExecution().getExecutionContext().getString("name"));

        System.out.println("BeforeStep (job parameters)::" + stepExecution.getJobExecution().getJobParameters());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("AfterStep (execution context -> 'name')::" + stepExecution.getJobExecution().getExecutionContext().getString("name"));
        return ExitStatus.COMPLETED;
    }
}
