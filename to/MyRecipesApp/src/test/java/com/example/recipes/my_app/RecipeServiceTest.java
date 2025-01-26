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
        recipe1.setTitle("Pasta");
        mockRecipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipe2.setTitle("Pizza");
        mockRecipes.add(recipe2);

        when(recipeRepository.findAll()).thenReturn(mockRecipes);

        List<Recipe> result = recipeService.getAllRecipes();

        assertEquals(2, result.size());
        assertEquals("Pasta", result.get(0).getTitle());
        assertEquals("Pizza", result.get(1).getTitle());

        verify(recipeRepository, times(1)).findAll();
    }
}
