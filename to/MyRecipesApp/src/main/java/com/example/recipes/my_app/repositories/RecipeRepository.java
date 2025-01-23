package com.example.recipes.my_app.repositories;

import com.example.recipes.my_app.model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository  extends JpaRepository<Recipe, Long> {
}
