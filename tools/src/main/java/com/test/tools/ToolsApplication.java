package com.test.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan("com.test.tools.controller") 
public class ToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsApplication.class, args);
	}

}
