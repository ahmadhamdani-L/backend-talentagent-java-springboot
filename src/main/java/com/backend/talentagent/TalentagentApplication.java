package com.backend.talentagent;

import com.backend.talentagent.storage.StorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class TalentagentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentagentApplication.class, args);
	}

}

