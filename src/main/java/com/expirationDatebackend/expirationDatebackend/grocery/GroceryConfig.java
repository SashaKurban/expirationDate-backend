package com.expirationDatebackend.expirationDatebackend.grocery;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@EnableEncryptableProperties
@Configuration
public class GroceryConfig {

    @Bean
    CommandLineRunner commandLineRunner(GroceryRepository groceryRepository){
        return args -> {

        };
    }
}
