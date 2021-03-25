package com.example.atat.Service;

import com.example.atat.domains.Recipe;
import com.example.atat.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    public static final int RETURNED_RECIPES = 1;
    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeService;



    @DisplayName("Testing returning null from the Repository")
    @Test
    void getRecipes() {
//        when
        var result= recipeService.getRecipes();
//        then
        assertNull(result);

    }

    @DisplayName("Testing Single Recipe Returned")
    @Test
    void testGetSingleRecipe(){
//        Given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        given(recipeRepository.findAll()).willReturn(recipes);

//        When
        var result= recipeService.getRecipes();

//        Then
        assertNotNull(result);
        assertEquals(RETURNED_RECIPES,result.size());
        then(recipeRepository).should().findAll();
        then(recipeRepository).shouldHaveNoMoreInteractions();
    }
}