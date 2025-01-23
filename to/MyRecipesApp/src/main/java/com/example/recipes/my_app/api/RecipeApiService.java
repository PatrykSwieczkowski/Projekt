package com.example.recipes.my_app.api;

import com.example.recipes.my_app.dto.NutrientRecipeDTO;
import com.example.recipes.my_app.dto.SummaryRecipeDTO;
import com.example.recipes.my_app.model.Recipe;
import com.example.recipes.my_app.repositories.RecipeRepository;
import com.example.recipes.my_app.responses.RecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeApiService {

    private final RecipeRepository recipeRepository;
    private final RestTemplate restTemplate;

    @Value("${spoonacular.api.key}")
    private String apiKey;


    private final String baseUrl = "https://api.spoonacular.com/recipes";


    @Autowired
    public RecipeApiService(RestTemplate restTemplate, RecipeRepository recipeRepository, @Value("${spoonacular.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.recipeRepository = recipeRepository;
        this.apiKey = apiKey;
    }


    public List<SummaryRecipeDTO> searchRecipes(String query, int number, Integer maxFat) {
        StringBuilder urlBuilder = new StringBuilder(String.format("%s/complexSearch?apiKey=%s&query=%s&number=%d", baseUrl, apiKey, query, number));

        if (maxFat != null) {
            urlBuilder.append("&maxFat=").append(maxFat);
        }

        String url = urlBuilder.toString();
        SummaryRecipeDTO response = restTemplate.getForObject(url, SummaryRecipeDTO.class);
        return List.of(response);
    }




    public List<Recipe> getRandomRecipes(int number, String includeTags, String excludeTags) {
        StringBuilder urlBuilder = new StringBuilder(String.format("%s/random?apiKey=%s&number=%d", baseUrl, apiKey, number));


        if (StringUtils.hasText(includeTags)) {
            urlBuilder.append("&tags=").append(includeTags);
        }
        if (StringUtils.hasText(excludeTags)) {
            urlBuilder.append("&excludeTags=").append(excludeTags);
        }

        String url = urlBuilder.toString();
        RecipeResponse response = restTemplate.getForObject(url, RecipeResponse.class);

        if (response.getRecipes() != null) {
            return response.getRecipes();
        }
        return List.of();
    }


    public List<Recipe> findRecipesByIngredients(List<String> ingredients, int number) {
        String ingredientsStr = String.join(",", ingredients);
        String url = String.format("%s/findByIngredients?ingredients=%s&number=%d&apiKey=%s", baseUrl, ingredientsStr, number, apiKey);
        Recipe[] response = restTemplate.getForObject(url, Recipe[].class);
        return Arrays.asList(response);
    }

    public List<NutrientRecipeDTO> findByCalories(int calories, Integer carbs, int number) {
        StringBuilder urlBuilder = new StringBuilder(String.format("%s/findByNutrients?apiKey=%s&maxCalories=%d&number=%d", baseUrl, apiKey, calories, number));

        if (carbs != null) {
            urlBuilder.append("&maxCarbs=").append(carbs);
        }

        String url = urlBuilder.toString();
        NutrientRecipeDTO[] response = restTemplate.getForObject(url, NutrientRecipeDTO[].class);
        return Arrays.asList(response);
    }


}





