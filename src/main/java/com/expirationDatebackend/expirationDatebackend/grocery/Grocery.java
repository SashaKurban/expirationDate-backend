package com.expirationDatebackend.expirationDatebackend.grocery;

import java.time.LocalDate;

public class Grocery {
    private Integer id;
    private String type;
    private String name;
    private String brand;
    private LocalDate dateOpened;
    private Integer daysToConsume;

    public Grocery() {
    }

    public Grocery(String type, String name, String brand, Integer daysToConsume) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.daysToConsume = daysToConsume;
        //if no dateOpened given, use current date
        this.dateOpened = LocalDate.now();
    }

    public Grocery(String type, String name, String brand, LocalDate dateOpened, Integer daysToConsume) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.dateOpened = dateOpened;
        this.daysToConsume = daysToConsume;
    }

    public String getType() {
        return type;
    }

    public Integer getId(){
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

    @Override
    public String toString() {
        return "Grocery{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", dateOpened=" + dateOpened +
                ", daysToConsume=" + daysToConsume +
                '}';
    }
}
