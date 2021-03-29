package com.example.atat.Service;

import com.example.atat.domains.Recipe;
import com.example.atat.repository.RecipeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    public static final int RETURNED_RECIPES = 1;
    public static final long RECIPE_ID = 1L;
    public static final int EXPECTED_ID = 1;
    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Captor
    ArgumentCaptor<Long> idCaptor;



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

    @DisplayName("Testing RecipeById should throws RunTimeException when recipe is not present")
    @Test
    void testGetRecipeById(){
//        When
        assertThrows(RuntimeException.class,()-> recipeService.getRecipeById(RECIPE_ID));

    }

    @DisplayName("Testing getting recipe")
    @Test
    void testGetRecipeByID(){
//        Given
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        given(recipeRepository.findById(idCaptor.capture())).willReturn(Optional.of(recipe));
//        When
        var result = recipeService.getRecipeById(RECIPE_ID);
//        Then
        assertEquals(EXPECTED_ID,result.getId());
        then(recipeRepository).should().findById(idCaptor.getValue());
        assertEquals(EXPECTED_ID,idCaptor.getValue());
        then(recipeRepository).shouldHaveNoMoreInteractions();
    }

}