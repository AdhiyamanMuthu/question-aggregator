package com.code.coder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.code.coder.service.PracticeService;

@SpringBootApplication
public class CoderApplication {
	
	@Autowired
	PracticeService ps;

	public static void main(String[] args)  {
		SpringApplication.run(CoderApplication.class, args);
	}

}
