package com.example.recipes.my_app.responses;

import com.example.recipes.my_app.model.Recipe;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeResponse {
    @JsonProperty("recipes")
    @JsonAlias("results")
    private List<Recipe> recipes;



    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
