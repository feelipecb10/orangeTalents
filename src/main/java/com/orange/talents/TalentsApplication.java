package com.orange.talents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TalentsApplication {

	public static void main(String[] args) {
	SpringApplication.run(TalentsApplication.class, args);
	}
}
