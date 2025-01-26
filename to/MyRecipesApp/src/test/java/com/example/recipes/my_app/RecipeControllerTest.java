package com.example.recipes.my_app.controllers;

import com.example.recipes.my_app.model.Recipe;
import com.example.recipes.my_app.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeControllerTest {

    @InjectMocks
    private RecipeController recipeController;

    @Mock
    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRecipes() {
        List<Recipe> mockRecipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setTitle("Salad");
        mockRecipes.add(recipe1);

        when(recipeService.getAllRecipes()).thenReturn(mockRecipes);

        List<Recipe> result = recipeController.getRecipes();

        assertEquals(1, result.size());
        assertEquals("Salad", result.get(0).getTitle());

        verify(recipeService, times(1)).getAllRecipes();
    }


}
