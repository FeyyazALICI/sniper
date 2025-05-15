package com.sniper.fileandbatch.components.batch.batchConfig;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sniper.fileandbatch.components.batch.job.HelloJob;

@Configuration
public class QuartzConfig {
    /*  SIMPLE HELLO JOB
    @Bean
    public JobDetail helloJobDetail() {
        return JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob")
                .storeDurably() // so it doesn't get deleted after run
                .build();
    }

    @Bean
    public Trigger helloJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(helloJobDetail())
                .withIdentity("helloTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
     */

}