package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    @Autowired
    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping
    public List<Grocery> getGroceries(){
        return groceryService.getGroceries();
    }

    @PostMapping
    public void addNewGrocery(@RequestBody Grocery grocery){
        groceryService.addNewGrocery(grocery);
    }
}


