package br.com.triad;

import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"br.com.triad",
		"br.com.triad.controller",
		"br.com.triad.service",
		"br.como.triad.swagger"})
@EnableCaching
public class TriadsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriadsystemApplication.class, args);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception
	{
		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(
				"127.0.0.1:27017"),"triadDB");

		return mongoTemplate;
	}

}
