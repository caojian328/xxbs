package com.zkai.financial;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DbApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DbApp.class).web(true).run(args);
	} 

} 
