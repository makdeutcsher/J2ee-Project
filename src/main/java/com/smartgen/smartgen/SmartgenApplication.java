package com.smartgen.smartgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.smartgen.smartgen.controller.storage.StorageProperties;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(StorageProperties.class)
public class SmartgenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartgenApplication.class, args);
	}

}
