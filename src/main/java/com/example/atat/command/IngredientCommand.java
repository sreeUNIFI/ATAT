package com.example.atat.command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private Long recipeId;
    private String ingDescription;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;
}
