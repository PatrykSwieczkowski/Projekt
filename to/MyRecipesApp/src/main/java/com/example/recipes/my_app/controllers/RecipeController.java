package com.example.recipes.my_app.controllers;


import com.example.recipes.my_app.model.Recipe;
import com.example.recipes.my_app.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class RecipeController {


    private final RecipeService recipeService;


    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipes")
    public List<Recipe> getRecipes() {
        return recipeService.getAllRecipes();
    }
}
