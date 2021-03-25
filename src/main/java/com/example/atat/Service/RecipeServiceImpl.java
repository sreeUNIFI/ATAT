package com.example.atat.Service;

import com.example.atat.domains.Recipe;
import com.example.atat.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private final RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("Getting Recipes");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        if (recipes.size()==0){
            log.error("recipes not found ");
            return null;
        }
        return recipes;
    }
}
