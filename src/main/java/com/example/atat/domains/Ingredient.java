package com.example.atat.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(exclude = {"recipe"})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingDescription;


    private BigDecimal amount;
    //    UnitOfMeasureRepository
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    //    RecipeRepository
    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String ingDescription, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.ingDescription = ingDescription;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

}
