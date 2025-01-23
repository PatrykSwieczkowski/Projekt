package com.example.recipes.my_app.services;


import com.example.recipes.my_app.model.Nutrition;
import com.example.recipes.my_app.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionService {


    private final NutritionRepository nutritionRepository;

    @Autowired
    public NutritionService(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    public List<Nutrition> getAllNutritions(){
        return nutritionRepository.findAll();
    }

}
