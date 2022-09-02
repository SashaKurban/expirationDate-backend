package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;

    @Autowired
    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getGroceries(){
        return groceryRepository.findAll();
    }

    public void addNewGrocery(Grocery grocery) {
        if(grocery.getDaysToConsume() == null && grocery.getExpirationDate()==null){
            throw new IllegalStateException("At least one filed must be provided: expiration date or days to consume");
        }else{
            groceryRepository.save(new Grocery(grocery));
        }

    }

    public void deleteGrocery(Long groceryId) {
        if(groceryRepository.existsById(groceryId)){
            groceryRepository.deleteById(groceryId);
        }else{
            throw new IllegalStateException("grocery with ID " + groceryId + " does not exist");
        }
    }
}
