package com.example.recipes.my_app.services;


import com.example.recipes.my_app.model.Recipe;
import com.example.recipes.my_app.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {


    private final RecipeRepository recipeRepository;



    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getAllRecipes() {
      return  recipeRepository.findAll();
    }
}
