package com.fatih_demo.fatih_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication()
@EntityScan(basePackages = "com.fatih_demo.fatih_Demo.entity")
public class FatihDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FatihDemoApplication.class, args);
	}

}
