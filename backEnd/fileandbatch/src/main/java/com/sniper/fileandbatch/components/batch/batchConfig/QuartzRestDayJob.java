package com.sniper.fileandbatch.components.batch.batchConfig;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sniper.fileandbatch.components.batch.job.DaysWithoutShootingJob;

@Configuration
public class QuartzRestDayJob {

    @Bean
    public JobDetail restDayJobDetail() {
        return JobBuilder.newJob(DaysWithoutShootingJob.class)
                .withIdentity("daysWithoutShootingJob")
                .storeDurably() // so it doesn't get deleted after run
                .build();
    }

    @Bean
    public Trigger restDayJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(restDayJobDetail())
                .withIdentity("daysWithoutShootingJob")
                .withSchedule(scheduleBuilder)
                .build();
    }

}