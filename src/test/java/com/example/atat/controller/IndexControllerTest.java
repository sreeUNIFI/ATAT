package com.example.atat.controller;

import com.example.atat.Service.RecipeService;
import com.example.atat.domains.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    MockMvc  mockMvc;

    @BeforeEach
    void setUp() {
        controller = new IndexController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getIndexPage(){
//        Given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        given(recipeService.getRecipes()).willReturn(Set.of(recipe));


//        When
        String webPage = controller.getIndexPage(model);

//        Then
        assertEquals("index",webPage);
        then(recipeService).should().getRecipes();
        then(recipeService).shouldHaveNoMoreInteractions();
    }

    @Test
    void testIndexPageStatus() throws Exception {

//        When
         controller.getIndexPage(model);

//        Then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("recipes"));

    }
}
