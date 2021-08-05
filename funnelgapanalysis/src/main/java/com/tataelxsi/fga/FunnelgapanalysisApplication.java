package com.tataelxsi.fga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FunnelgapanalysisApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(FunnelgapanalysisApplication.class);
	   
	
   
	public static void main(String[] args) {
		SpringApplication.run(FunnelgapanalysisApplication.class, args);
		logger.info("Application started...");
	}

}
