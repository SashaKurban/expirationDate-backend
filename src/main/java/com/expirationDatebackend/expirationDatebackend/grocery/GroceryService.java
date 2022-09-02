package com.expirationDatebackend.expirationDatebackend.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public void updateGrocery(Long groceryId, String name, String brand, String type,
                              String dateOpened, String expirationDate, Integer daysToConsume) {
        Grocery grocery = groceryRepository.findById(groceryId).orElseThrow(
                ()->new IllegalStateException
                        ("grocery with id " + groceryId + "does not exist"));
        if(name != null && name.length() > 0 && !Objects.equals(grocery.getName(), name)){
            grocery.setName(name);
        }
        if(brand != null && brand.length() > 0 && !Objects.equals(grocery.getBrand(), brand)){
            grocery.setBrand(brand);
        }
        if(type != null && type.length() > 0 && !Objects.equals(grocery.getType(), type)){
            grocery.setType(type);
        }
        if(dateOpened != null){
            LocalDate dateOpenedConverted = LocalDate.parse(dateOpened);
            if(!Objects.equals(grocery.getDateOpened(), dateOpenedConverted))
                grocery.setDateOpened(dateOpenedConverted);
        }
        if(expirationDate != null){
            LocalDate expirationDateConverted = LocalDate.parse(expirationDate);
            if(!Objects.equals(grocery.getExpirationDate(), expirationDateConverted))
                grocery.setExpirationDate(expirationDateConverted);
        }
        if(daysToConsume != null && daysToConsume > 0 && !Objects.equals(grocery.getDaysToConsume(), daysToConsume)){
            grocery.setDaysToConsume(daysToConsume);
        }
    }
}
