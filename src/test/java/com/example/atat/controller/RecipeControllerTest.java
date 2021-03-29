package com.example.atat.controller;

import com.example.atat.Service.RecipeService;
import com.example.atat.domains.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    public static final long RECIPE_ID = 1L;

    @Mock
    Model model;

    @Captor
    ArgumentCaptor<Long> recipeId;

    @Mock
    RecipeService recipeService;


    RecipeController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }



    @Test
    void viewRecipe(){
//        Given
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        given(recipeService.getRecipeById(recipeId.capture())).willReturn(recipe);
//        When
        String  webpage = controller.viewRecipe(recipe.getId().toString(),model);
//        then
        assertEquals("recipe/show",webpage);
        then(recipeService).should().getRecipeById(recipeId.getValue());
        assertEquals(RECIPE_ID,recipeId.getValue());
        then(recipeService).shouldHaveNoMoreInteractions();
    }


    @Test
    void testStatusOfController() throws Exception {
//        Given
        given(recipeService.getRecipeById(recipeId.capture())).willReturn(new Recipe());


//        Then
        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
        then(recipeService).should().getRecipeById(anyLong());
        then(recipeService).shouldHaveNoMoreInteractions();
    }


}