package com.example.recipes.my_app.repositories;

import com.example.recipes.my_app.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
