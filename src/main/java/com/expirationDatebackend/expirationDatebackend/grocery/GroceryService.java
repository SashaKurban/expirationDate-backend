package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {
    public List<Grocery> getGroceries(){
        return List.of(new Grocery("spread", "humus", "Nature Valley", 2));
    }
}
