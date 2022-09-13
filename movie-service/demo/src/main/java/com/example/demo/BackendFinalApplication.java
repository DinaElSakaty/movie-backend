package com.example.demo;

import com.example.demo.services.Movie;
import com.example.demo.services.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class BackendFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFinalApplication.class, args);
	}


}
