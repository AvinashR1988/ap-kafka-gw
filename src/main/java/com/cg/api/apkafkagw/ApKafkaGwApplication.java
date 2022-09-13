package com.cg.api.apkafkagw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ApKafkaGwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApKafkaGwApplication.class, args);
	}

}
