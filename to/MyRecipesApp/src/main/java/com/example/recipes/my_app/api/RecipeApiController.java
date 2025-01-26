package com.example.recipes.my_app.api;

import com.example.recipes.my_app.dto.NutrientRecipeDTO;
import com.example.recipes.my_app.dto.SummaryRecipeDTO;
import com.example.recipes.my_app.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recipes")
public class RecipeApiController {

    private final RecipeApiService recipeApiService;

    @Autowired
    public RecipeApiController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @GetMapping("findByIngredients/{ingredients}")
    public ResponseEntity<List<Recipe>> findRecipesByIngredients(@PathVariable List<String> ingredients,
                                                                 @RequestParam(defaultValue = "5") int number) {
        List<Recipe> recipes = recipeApiService.findRecipesByIngredients(ingredients, number);
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/random")
    public ResponseEntity<List<Recipe>> getRandomRecipes(@RequestParam(defaultValue = "1") int number,
                                                         @RequestParam(required = false) String includeTags,
                                                         @RequestParam(required = false) String excludeTags) {
        List<Recipe> recipes = recipeApiService.getRandomRecipes(number, includeTags, excludeTags);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/search/{query}")
    public ResponseEntity<List<SummaryRecipeDTO>> searchRecipes(@PathVariable String query,
                                                                @RequestParam(defaultValue = "10") int number,
                                                                @RequestParam(required = false) Integer maxFat) {
        List<SummaryRecipeDTO> recipes = recipeApiService.searchRecipes(query, number, maxFat);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/findByCalories/{calories}")
    public ResponseEntity<List<NutrientRecipeDTO>> findRecipesByCalories(@PathVariable int calories,
                                                                         @RequestParam(required = false) Integer carbs,
                                                                         @RequestParam(defaultValue = "5") int number) {
        List<NutrientRecipeDTO> recipes = recipeApiService.findByCalories(calories, carbs, number);
        return ResponseEntity.ok(recipes);
    }
}
