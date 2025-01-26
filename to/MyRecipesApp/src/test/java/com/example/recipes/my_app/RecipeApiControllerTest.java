package com.example.recipes.my_app.api;

import com.example.recipes.my_app.dto.NutrientRecipeDTO;
import com.example.recipes.my_app.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeApiControllerTest {

    private MockMvc mockMvc;
    private RecipeApiService recipeApiService;
    private RecipeApiController recipeApiController;

    @BeforeEach
    void setUp() {

        recipeApiService = Mockito.mock(RecipeApiService.class);

        recipeApiController = new RecipeApiController(recipeApiService);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeApiController).build();
    }

    @Test
    void testFindRecipesByCaloriesWithResults() throws Exception {
        NutrientRecipeDTO recipe1 = new NutrientRecipeDTO();
        recipe1.setId(1);
        recipe1.setTitle("Low Calorie Salad");
        recipe1.setCalories(400);

        NutrientRecipeDTO recipe2 = new NutrientRecipeDTO();
        recipe2.setId(2);
        recipe2.setTitle("Low Calorie Soup");
        recipe2.setCalories(450);

        List<NutrientRecipeDTO> mockResponse = Arrays.asList(recipe1, recipe2);

        when(recipeApiService.findByCalories(500, 50, 5)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/recipes/findByCalories/500")
                        .param("carbs", "50")
                        .param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Low Calorie Salad"))
                .andExpect(jsonPath("$[1].title").value("Low Calorie Soup"));
    }

    @Test
    void testFindRecipesByCaloriesWithNoResults() throws Exception {
        when(recipeApiService.findByCalories(500, null, 5)).thenReturn(List.of());

        mockMvc.perform(get("/api/recipes/findByCalories/500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testFindRecipesByIngredientsWithResults() throws Exception {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setTitle("Tomato Soup");

        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipe2.setTitle("Vegetable Salad");

        List<Recipe> mockResponse = Arrays.asList(recipe1, recipe2);

        when(recipeApiService.findRecipesByIngredients(Arrays.asList("tomato", "lettuce"), 5)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/recipes/findByIngredients/tomato,lettuce")
                        .param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Tomato Soup"))
                .andExpect(jsonPath("$[1].title").value("Vegetable Salad"));
    }

    @Test
    void testGetRandomRecipesWithResults() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setTitle("Random Recipe");

        List<Recipe> mockResponse = List.of(recipe);

        when(recipeApiService.getRandomRecipes(1, null, null)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/recipes/random")
                        .param("number", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Random Recipe"));
    }
}
