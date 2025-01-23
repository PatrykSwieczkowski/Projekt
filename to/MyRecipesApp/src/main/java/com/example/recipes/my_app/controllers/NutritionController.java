package com.example.recipes.my_app.controllers;


import com.example.recipes.my_app.model.Nutrition;
import com.example.recipes.my_app.services.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NutritionController {

    private final NutritionService nutritionService;

    @Autowired
    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @GetMapping("nutritions")
    public List<Nutrition> getNutritions() {
        return nutritionService.getAllNutritions();
    }
}
