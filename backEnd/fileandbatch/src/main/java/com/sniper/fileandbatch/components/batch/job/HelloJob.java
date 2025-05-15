package com.sniper.fileandbatch.components.batch.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import com.sniper.fileandbatch.components.batch.jobService.HelloService;

@Component
public class HelloJob implements Job {

    private final HelloService helloService;

    public HelloJob(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void execute(JobExecutionContext context) {
        helloService.sayHello();
    }
}
