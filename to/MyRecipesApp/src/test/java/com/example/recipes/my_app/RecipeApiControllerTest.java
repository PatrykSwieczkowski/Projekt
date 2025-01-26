package com.example.recipes.my_app.controllers;

import com.example.recipes.my_app.api.RecipeApiController;
import com.example.recipes.my_app.api.RecipeApiService;
import com.example.recipes.my_app.model.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecipeApiController.class)
class RecipeApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecipeApiService recipeApiService;

    @Test
    void testGetRandomRecipes() throws Exception {
        // Mockowanie danych
        List<Recipe> mockRecipes = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setTitle("Random Recipe");
        mockRecipes.add(recipe);

        when(recipeApiService.getRandomRecipes(2, null, null)).thenReturn(mockRecipes);

        // Testowanie endpointu GET /random
        mockMvc.perform(get("/random?number=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Random Recipe"));
    }
}
