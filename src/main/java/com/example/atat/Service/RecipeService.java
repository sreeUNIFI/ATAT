package com.example.atat.Service;

import com.example.atat.domains.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe getRecipeById(Long recipeID);
}
