package com.play.Permier_zone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PermierZoneApplication {

	public static void main(String[] args) {

		SpringApplication.run(PermierZoneApplication.class, args);

		System.out.print("---------------- myProject --------------");
	}

}
