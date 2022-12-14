package com.mukesh.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan({"com.mukesh.resource","com.mukesh.service","com.mukesh.config"})
@EntityScan("com.mukesh.dataModel")
@EnableJpaRepositories("com.mukesh.repository")
@EnableEurekaClient
public class ItemServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

}
