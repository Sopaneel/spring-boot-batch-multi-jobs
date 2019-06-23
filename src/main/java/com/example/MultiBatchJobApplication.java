package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class MultiBatchJobApplication {
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("jobOne")
	Job jobOne;
	
	@Autowired
	@Qualifier("jobTwo")
	Job jobTwo;
	
	public static void main(String[] args) {
		SpringApplication.run(MultiBatchJobApplication.class, args);
	}
	
	@Scheduled(cron="0 18 16 * * ?")
	public void runJobOne() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder().addString("JobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(jobOne, jobParameters);
	}
	
	@Scheduled(cron="0 18 16 * * ?")
	public void runJobTwo() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder().addString("JobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(jobTwo, jobParameters);
	}
}
