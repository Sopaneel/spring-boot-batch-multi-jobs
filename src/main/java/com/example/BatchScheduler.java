package com.example;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableScheduling
public class BatchScheduler {

//	@Bean
//	public ResourcelessTransactionManager transactionManager() {
//		return new ResourcelessTransactionManager();
//	}
//
//	@Bean
//	public MapJobRepositoryFactoryBean mapJobRepositoryFactory(
//	ResourcelessTransactionManager txManager) throws Exception {
//	MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(
//				txManager);
//		factory.afterPropertiesSet();
//		return factory;
//	}
//	
//       @Bean
//	public JobRepository jobRepository(MapJobRepositoryFactoryBean factory)
//			throws Exception {
//		return (JobRepository) factory.getObject();
//	}
//
//	@Bean
//	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
//		SimpleJobLauncher launcher = new SimpleJobLauncher();
//		launcher.setJobRepository(jobRepository);
//		return launcher;
//	}

}
