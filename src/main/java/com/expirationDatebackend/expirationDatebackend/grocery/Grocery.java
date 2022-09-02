package com.expirationDatebackend.expirationDatebackend.grocery;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class Grocery {
    @Id
    @SequenceGenerator(
            name = "grocery_sequence",
            sequenceName = "grocery_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "grocery_sequence"
    )
    private Long id;
    private String type;
    private String name;
    private String brand;
    private LocalDate dateOpened;
    private Integer daysToConsume;
    private LocalDate expirationDate;
    @Transient
    private Integer daysLeft;

    public Grocery() {
    }

    public Grocery(String type, String name, String brand, Integer daysToConsume) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.daysToConsume = daysToConsume;
        //if no dateOpened given, use current date
        this.dateOpened = LocalDate.now();
        this.expirationDate = dateOpened.plusDays(daysToConsume);
    }

    public Grocery(String type, String name, String brand, LocalDate dateOpened, Integer daysToConsume) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.dateOpened = dateOpened;
        this.daysToConsume = daysToConsume;
        this.expirationDate = dateOpened.plusDays(daysToConsume);
    }

    public Grocery(Long id, String type, String name, String brand, LocalDate expirationDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.dateOpened = LocalDate.now();
        this.expirationDate = expirationDate;
        this.daysToConsume = Period.between( LocalDate.now(), expirationDate).getDays();
    }

    public String getType() {
        return type;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public Integer getDaysToConsume() {
        return daysToConsume;
    }

    public LocalDate getExpirationDate(){
        return expirationDate;
    }

    public Integer getDaysLeft() {
        return Period.between(LocalDate.now(), expirationDate).getDays();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public void setDaysToConsume(Integer daysToConsume) {
        this.daysToConsume = daysToConsume;
    }

    public void setExpirationDate(LocalDate expirationDate){
        this.expirationDate= expirationDate;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        return "Grocery{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", dateOpened=" + dateOpened.format(formatter) +
                ", daysToConsume=" + daysToConsume +
                ", expirationDate =" + expirationDate+
                ", days left= " + this.getDaysLeft() +
                '}';
    }


}
