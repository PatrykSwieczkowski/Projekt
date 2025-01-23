package com.example.recipes.my_app.services;



import com.example.recipes.my_app.model.Ingredient;
import com.example.recipes.my_app.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

   public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
   }

}
