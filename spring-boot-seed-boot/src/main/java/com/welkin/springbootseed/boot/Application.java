package com.welkin.springbootseed.boot;

import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.welkin.springbootseed"},
		includeFilters = {@ComponentScan.Filter(Api.class)}
)
@MapperScan(
		basePackages = {"com.welkin.springbootseed.dao"}
)
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
