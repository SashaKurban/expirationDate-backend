package com.expirationDatebackend.expirationDatebackend;

import com.expirationDatebackend.expirationDatebackend.grocery.Grocery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ExpirationDateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpirationDateBackendApplication.class, args);

	}

	@GetMapping
	public List<Grocery> mapping(){
		return List.of(new Grocery("spread", "humus", "Nature Valley", 2));
	}
}

