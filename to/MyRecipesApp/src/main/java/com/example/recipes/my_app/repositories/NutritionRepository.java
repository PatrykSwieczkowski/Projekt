package com.example.recipes.my_app.repositories;

import com.example.recipes.my_app.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
}
