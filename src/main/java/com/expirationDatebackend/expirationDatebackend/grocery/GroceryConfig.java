package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class GroceryConfig {

    @Bean
    CommandLineRunner commandLineRunner(GroceryRepository groceryRepository){
        return args -> {
            Grocery humus = new Grocery("spread", "humus", "Nature Valley", 2);
            Grocery bread = new Grocery("bakery", "bread", "Panera", 9);
            Grocery chicken = new Grocery("meat", "chicken", "Nature", LocalDate.of(2022, 10, 9));

            groceryRepository.saveAll(List.of(humus, bread,chicken));
        };
    }
}
