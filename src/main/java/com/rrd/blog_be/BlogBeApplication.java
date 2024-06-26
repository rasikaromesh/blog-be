package com.rrd.blog_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.rrd.blog_be.repository")
public class BlogBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogBeApplication.class, args);
	}

}
