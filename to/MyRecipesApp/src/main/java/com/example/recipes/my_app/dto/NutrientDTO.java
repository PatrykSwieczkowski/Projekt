package com.example.recipes.my_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutrientDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("unit")
    private String unit;


    public NutrientDTO() {
    }


    public NutrientDTO(String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
