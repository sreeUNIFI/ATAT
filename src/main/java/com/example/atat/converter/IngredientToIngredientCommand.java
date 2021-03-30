package com.example.atat.converter;

import com.example.atat.command.IngredientCommand;
import com.example.atat.domains.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand) {
        this.toUnitOfMeasureCommand = toUnitOfMeasureCommand;
    }

    @Override
    @Synchronized
    @Nullable
    public IngredientCommand convert(Ingredient ingredient) {

        if (ingredient==null){
            return null;
        }


        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        if (ingredient.getRecipe() != null) {
            ingredientCommand.setRecipeId(ingredient.getRecipe().getId());
        }
        ingredientCommand.setIngDescription(ingredient.getIngDescription());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setUnitOfMeasure(toUnitOfMeasureCommand.convert(ingredient.getUnitOfMeasure()));
        return ingredientCommand; }
}
