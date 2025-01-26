package ru.gocinema.server;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GoCinemaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoCinemaServerApplication.class, args);
	}

	@Bean
	public Module javaTimeModule() {
		var module = new JavaTimeModule();
		module.addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return module;
	}
}
