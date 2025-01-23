package com.example.recipes.my_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NutritionDTO {

    public NutritionDTO() {

    }

    @JsonProperty("nutrients")
    private List<NutrientDTO> nutrients;

    public List<NutrientDTO> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<NutrientDTO> nutrients) {
        this.nutrients = nutrients;
    }
}
