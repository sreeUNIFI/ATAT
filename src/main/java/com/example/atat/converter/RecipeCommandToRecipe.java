package com.example.atat.converter;

import com.example.atat.command.RecipeCommand;
import com.example.atat.domains.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final IngredientCommandToIngredient toIngredient;
    private final NotesCommandToNotes toNotes;

    public RecipeCommandToRecipe(IngredientCommandToIngredient toIngredient, NotesCommandToNotes toNotes) {
        this.toIngredient = toIngredient;
        this.toNotes = toNotes;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {

        if (recipeCommand==null){
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirection(recipeCommand.getDirection());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setNotes(toNotes.convert(recipeCommand.getNotes()));

        if (recipeCommand.getIngredientSet()!=null&&recipeCommand.getIngredientSet().size()>0){
            recipeCommand.getIngredientSet().forEach(
                    ingredientCommand -> recipe.getIngredientSet().add(toIngredient.convert(ingredientCommand))
            );

        }
        return recipe; }
}
