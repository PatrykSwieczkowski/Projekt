package com.example.recipes.my_app.controllers;

import com.example.recipes.my_app.model.Ingredient;
import com.example.recipes.my_app.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredientService.getAllIngredients();
    }

}
