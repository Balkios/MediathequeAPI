package org.formation.mediatheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.formation.mediatheque.model","org.formation.mediatheque.service","org.formation.mediatheque.repository","org.formation.mediatheque.controller"})
public class MediathequeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediathequeApiApplication.class, args);
	}

}
