package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GroceryConfig {

    @Bean
    CommandLineRunner commandLineRunner(GroceryRepository groceryRepository){
        return args -> {
            Grocery humus = new Grocery("spread", "humus", "Nature Valley", 2);
            Grocery bread = new Grocery("bakery", "bread", "Pannera", 9);

            groceryRepository.saveAll(List.of(humus, bread));
        };
    }
}
