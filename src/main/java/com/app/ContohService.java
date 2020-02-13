package com.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ContohService {

    private static final Logger logger = LoggerFactory.getLogger(ContohService.class);


    @Async("threadPoolTaskExecutor")

    public CompletableFuture < String > findUser(String user)  {
    	System.out.println("jalan nga sih ini");
        logger.info("Looking up " + user);
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("page..CancellationException");  
        	return CompletableFuture.completedFuture("patar interupted");

        }

        try {
			TimeUnit.SECONDS.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return CompletableFuture.completedFuture("patar");

    }
    
}
