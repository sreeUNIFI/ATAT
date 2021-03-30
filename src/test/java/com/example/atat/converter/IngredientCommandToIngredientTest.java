package com.example.atat.converter;

import com.example.atat.command.IngredientCommand;
import com.example.atat.domains.Ingredient;
import com.example.atat.domains.Recipe;
import com.example.atat.domains.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final Long UOM_ID = 2L;
    public static final long RECIPE_ID = 1L;

    IngredientCommandToIngredient toIngredient;
    @BeforeEach
    void setUp() {
        toIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void testEmptyObject(){

        assertNotNull(toIngredient.convert(new IngredientCommand()));
    }

    @Test
    void testNullObject(){
        assertNull(toIngredient.convert(null));
    }


    @Test
    void convert() {
//        given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setIngDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        command.setRecipeId(RECIPE_ID);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        command.setUnitOfMeasure(new UnitOfMeasureToUnitOfMeasureCommand().convert(unitOfMeasure));

//        when
        Ingredient ingredient = toIngredient.convert(command);

//        then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUnitOfMeasure());
        assertEquals(ID_VALUE,ingredient.getId());
        assertEquals(DESCRIPTION,ingredient.getIngDescription());
        assertEquals(AMOUNT,ingredient.getAmount());
        assertEquals(UOM_ID,ingredient.getUnitOfMeasure().getId());
        assertEquals(RECIPE_ID,ingredient.getRecipe().getId());
    }
}