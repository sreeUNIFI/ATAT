package com.example.atat.converter;

import com.example.atat.command.IngredientCommand;
import com.example.atat.command.NotesCommand;
import com.example.atat.command.RecipeCommand;
import com.example.atat.command.UnitOfMeasureCommand;
import com.example.atat.domains.Difficulty;
import com.example.atat.domains.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

    public static final Long RECIPE_ID = 1L;
    public static final Integer COOK_TIME = Integer.valueOf("5");
    public static final Integer PREP_TIME = Integer.valueOf("7");
    public static final String DESCRIPTION = "My Recipe";
    public static final String DIRECTIONS = "Directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final Integer SERVINGS = Integer.valueOf("3");
    public static final String SOURCE = "Source";
    public static final String URL = "Some URL";
    public static final Long INGRED_ID_1 = 3L;
    public static final Long INGRED_ID_2 = 4L;
    public static final Long NOTES_ID = 9L;

    RecipeCommandToRecipe toRecipe;

    @BeforeEach
    void setUp() {
        toRecipe = new RecipeCommandToRecipe(new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    void testNullObject(){
        assertNull(toRecipe.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(toRecipe.convert(new RecipeCommand()));

    }


    @Test
    void convert() {
//        Given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirection(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);


        NotesCommand notes = new NotesCommand();
        notes.setId(NOTES_ID);

        recipeCommand.setNotes(notes);
        IngredientCommand ingredient = new IngredientCommand();
        ingredient.setId(INGRED_ID_1);
        ingredient.setUnitOfMeasure(new UnitOfMeasureCommand());

        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(INGRED_ID_2);
        ingredient2.setUnitOfMeasure(new UnitOfMeasureCommand());

        recipeCommand.getIngredientSet().add(ingredient);
        recipeCommand.getIngredientSet().add(ingredient2);
//        When

        Recipe recipe  = toRecipe.convert(recipeCommand);


//        Then

        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirection());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getIngredientSet().size());


    }
}