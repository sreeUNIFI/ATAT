package com.example.atat.converter;

import com.example.atat.command.IngredientCommand;
import com.example.atat.domains.Ingredient;
import com.example.atat.domains.Recipe;
import com.example.atat.domains.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final Long UOM_ID = 2L;
    public static final long RECIPE_ID = 1L;

    IngredientToIngredientCommand toIngredientCommand;

    @BeforeEach
    void setUp() {
        toIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    void testEmptyObject(){
        assertNotNull(toIngredientCommand.convert(new Ingredient()));
    }

    @Test
    void testNullObject(){
        toIngredientCommand.convert(null);
    }

    @Test
    void convert() {
//        Given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setIngDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        ingredient.setRecipe(recipe);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUnitOfMeasure(unitOfMeasure);
//        When
        IngredientCommand command = toIngredientCommand.convert(ingredient);

//        Then
        assertNotNull(command);
        assertNotNull(command.getUnitOfMeasure());
        assertNotNull(command.getRecipeId());
        assertEquals(RECIPE_ID,command.getRecipeId());
        assertEquals(ID_VALUE,command.getId());
        assertEquals(DESCRIPTION,command.getIngDescription());
        assertEquals(AMOUNT,command.getAmount());
        assertEquals(UOM_ID,command.getUnitOfMeasure().getId());
    }
}