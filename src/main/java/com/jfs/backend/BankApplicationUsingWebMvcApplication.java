package com.jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jfs.backend.repository.AccountRepository;

@SpringBootApplication
public class BankApplicationUsingWebMvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BankApplicationUsingWebMvcApplication.class, args);
		context.getBean(AccountRepository.class);
	}

}
