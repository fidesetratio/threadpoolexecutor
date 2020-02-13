package com.app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private ContohService contohService;
	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		CompletableFuture < String > page1 =	contohService.findUser("patar");
		
		try {
			
			
				String g = page1.get(3, TimeUnit.SECONDS);
				return new ResponseEntity<>(g, HttpStatus.OK);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt(); 
			page1.cancel(true); 
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
}
