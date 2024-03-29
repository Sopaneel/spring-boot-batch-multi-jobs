package com.example;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableBatchProcessing
public class BatchConfigJob {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

//	@Autowired
//	private SimpleJobLauncher jobLauncher;
//
//	@Scheduled(cron = "0 0/1 * 1/1 * ?")
//	public void sendSmsForExpiringBookmark() throws Exception {
//		System.out.println(" Job Started at :" + new Date());
//		JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
//				.toJobParameters();
//		JobExecution execution = jobLauncher.run(job(), param);
//		System.out.println("Job finished with status :" + execution.getStatus());
//	}

	public Job job() {
		return jobBuilderFactory.get("jobTwo").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

	public Step step1() {
		return stepBuilderFactory.get("step2").<String, String>chunk(1).reader(new ReaderImpl())
				.processor(new ProcessorImpl()).writer(new WriterImpl()).build();
	}
}
