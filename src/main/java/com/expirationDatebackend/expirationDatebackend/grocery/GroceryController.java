package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @DeleteMapping(path = "{groceryId}")
    public void deleteGrocery(@PathVariable("groceryId") Long groceryId){
        groceryService.deleteGrocery(groceryId);
    }

    @PutMapping(path="{groceryId}")
    public void updateGrocery(@PathVariable("groceryId") Long groceryId,
                              @RequestParam(required=false) String name,
                              @RequestParam(required=false) String brand,
                              @RequestParam(required=false) String type,
                              @RequestParam(required=false) String dateOpened,
                              @RequestParam(required=false) String expirationDate,
                              @RequestParam(required=false) Integer daysToConsume){
        groceryService.updateGrocery(groceryId, name, brand, type, dateOpened, expirationDate, daysToConsume);
    }
}


