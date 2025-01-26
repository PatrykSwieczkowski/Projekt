package com.example.recipes.my_app.services;

import com.example.recipes.my_app.model.Recipe;
import com.example.recipes.my_app.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRecipes() {
        List<Recipe> mockRecipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setTitle("Salad");
        mockRecipes.add(recipe1);

        when(recipeRepository.findAll()).thenReturn(mockRecipes);

        List<Recipe> result = recipeService.getAllRecipes();

        assertEquals(1, result.size());
        assertEquals("Salad", result.get(0).getTitle());

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void testSaveRecipe() {
        Recipe newRecipe = new Recipe();
        newRecipe.setId(3L);
        newRecipe.setTitle("Pasta");

        when(recipeRepository.save(any(Recipe.class))).thenReturn(newRecipe);

        recipeService.saveRecipe(newRecipe);

        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }
}
