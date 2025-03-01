package ru.gocinema.server;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
public class GoCinemaServerApplication {

	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

	public static void main(String[] args) {
		SpringApplication.run(GoCinemaServerApplication.class, args);
	}

	@Bean
	public Module javaTimeModule() {
		var module = new JavaTimeModule();
		module.addSerializer(LocalTime.class, new LocalTimeSerializer(TIME_FORMATTER));
		return module;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
			}
		};
	}

	@Bean
	public AuthenticationEntryPoint commence() {
		return (request, response, accessDeniedException) -> {
			response.addHeader("Access-Control-Allow-Origin", "*");
		};
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(request -> request
						.requestMatchers("/", "/swagger/**", "/swagger-ui/**", "/h2-console/**")
						.permitAll()
						.requestMatchers(HttpMethod.OPTIONS)
						.permitAll()
						.anyRequest()
						.authenticated())
				.httpBasic(Customizer.withDefaults())
				.exceptionHandling(config -> {
					config.authenticationEntryPoint(commence());
				})
				.csrf(config -> {
					config.disable();
				})
				.headers(config -> {
					config.frameOptions(fconfig -> {
						fconfig.disable();
					});
				})
				.build();
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
