package kr.pe.jonghak.demo.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUserApiApplication.class, args);
	}

}
