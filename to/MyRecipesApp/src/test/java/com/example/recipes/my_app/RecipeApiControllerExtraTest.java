package com.example.recipes.my_app.api;

import com.example.recipes.my_app.dto.SummaryRecipeDTO;
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

class RecipeApiControllerExtraTest {

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
    void testSearchRecipesWithResults() throws Exception {

        SummaryRecipeDTO recipe1 = new SummaryRecipeDTO();
        recipe1.setId(1L);
        recipe1.setTitle("Spaghetti Carbonara");

        SummaryRecipeDTO recipe2 = new SummaryRecipeDTO();
        recipe2.setId(2L);
        recipe2.setTitle("Chicken Curry");

        List<SummaryRecipeDTO> mockResponse = Arrays.asList(recipe1, recipe2);

        when(recipeApiService.searchRecipes("spaghetti", 10, null)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/recipes/search/spaghetti")
                        .param("number", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Spaghetti Carbonara"))
                .andExpect(jsonPath("$[1].title").value("Chicken Curry"));
    }

    @Test
    void testSearchRecipesWithNoResults() throws Exception {
        when(recipeApiService.searchRecipes("nonexistent", 10, null)).thenReturn(List.of());

        mockMvc.perform(get("/api/recipes/search/nonexistent")
                        .param("number", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
