package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//Za pomocą tej adnotacji oznaczamy że mamy do czynienia z aplikacją SpringBootową
@SpringBootApplication
//SpringBootServletInitializer wymusza na nas implementacje metody configure() - zastosowanie tej klasy abstrakcyjnej wymusza na SpringBoocie
//odpalenie naszej aplikacji z .war'a
public class BootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(BootApplication.class);
	}

	public static void main(String[] args) {
		//ustawiamy po to żeby nasze pliki .property dla locales miały odpowiednie kodowanie podczas ładowania ich do aplikacji
		System.setProperty("file.encoding","UTF-8");
		SpringApplication.run(BootApplication.class, args);
	}

}
