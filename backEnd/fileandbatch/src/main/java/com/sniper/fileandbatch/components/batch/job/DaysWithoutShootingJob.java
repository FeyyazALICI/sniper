package com.sniper.fileandbatch.components.batch.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.sniper.fileandbatch.components.batch.jobService.DaysWithoutShootingJobService;

@Component
public class DaysWithoutShootingJob implements Job {

    private final DaysWithoutShootingJobService service;

    public DaysWithoutShootingJob(DaysWithoutShootingJobService service) {
        this.service = service;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            service.findRestDays();
        } catch (Exception e) {
            // Wrap and rethrow as JobExecutionException
            throw new JobExecutionException("Failed to execute DaysWithoutShootingJob", e);
        }
    }
}
