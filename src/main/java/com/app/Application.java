package com.app;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class Application implements CommandLineRunner  {

	
    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(1);

        executor.setMaxPoolSize(1);

        executor.setWaitForTasksToCompleteOnShutdown(true);

        executor.setThreadNamePrefix("Async-");
        executor.setRejectedExecutionHandler(  new ThreadPoolExecutor.DiscardPolicy());
        return executor;

    }
    
    
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
    
	

}
